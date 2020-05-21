package fr.pederobien.minecraftgameplateform.helpers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.bukkit.command.PluginCommand;

import fr.pederobien.minecraftgameplateform.exceptions.CommandNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommandHelper;
import fr.pederobien.minecraftgameplateform.interfaces.commands.IParentCommand;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

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
	public <T extends IUnmodifiableNominable> void register(IParentCommand<T> command) {
		PluginCommand cmd = checkCommand(command);
		cmd.setExecutor(command);
		cmd.setTabCompleter(command.getTabCompleter());
		commands.put(command.getLabel(), command);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IUnmodifiableNominable> Optional<IParentCommand<T>> getCommand(String label) {
		ICommand command = commands.get(label);
		return command == null ? Optional.empty() : Optional.of((IParentCommand<T>) command);
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
