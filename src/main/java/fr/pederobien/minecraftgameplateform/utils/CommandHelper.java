package fr.pederobien.minecraftgameplateform.utils;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.PluginCommand;

import fr.pederobien.minecraftgameplateform.exceptions.CommandNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommandHelper;

public class CommandHelper implements ICommandHelper {
	private Map<String, ICommand> commands;

	private CommandHelper() {
		commands = new HashMap<String, ICommand>();
	}

	public static ICommandHelper getInstance() {
		return SingletonHolder.HELPER;
	}

	private static class SingletonHolder {
		public static final ICommandHelper HELPER = new CommandHelper();
	}

	@Override
	public void register(ICommand command) {
		PluginCommand cmd = checkCommand(command);
		cmd.setExecutor(command);
		cmd.setTabCompleter(command.getTabCompleter());
		commands.put(command.getLabel(), command);
	}

	@Override
	public void setAllAvailable(boolean available) {
		commands.values().forEach(c -> c.setAvailable(available));
	}

	@Override
	public boolean setAvailable(String label, boolean available) {
		ICommand cmd = commands.get(label);
		if (cmd != null)
			cmd.setAvailable(available);
		return cmd != null;
	}

	private PluginCommand checkCommand(ICommand command) {
		PluginCommand cmd = command.getPlugin().getCommand(command.getLabel());
		if (cmd == null)
			throw new CommandNotFoundException(command.getPlugin(), command.getLabel());
		return cmd;
	}
}
