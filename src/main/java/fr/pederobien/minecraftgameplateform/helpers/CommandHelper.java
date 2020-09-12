package fr.pederobien.minecraftgameplateform.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bukkit.command.PluginCommand;

import fr.pederobien.minecraftgameplateform.exceptions.CommandAlreadyRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.CommandNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommandHelper;

public class CommandHelper implements ICommandHelper {
	private Map<String, ICommand> commands;
	private List<ICommand> commandsList;

	private CommandHelper() {
		commands = new HashMap<String, ICommand>();
		commandsList = new ArrayList<ICommand>();
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

		if (commands.get(command.getLabel()) != null)
			throw new CommandAlreadyRegisteredException(command.getLabel());

		commands.put(command.getLabel(), command);
		commandsList = new ArrayList<>(commands.values());
	}

	@Override
	public Optional<ICommand> getCommand(String label) {
		return Optional.ofNullable(commands.get(label));
	}

	@Override
	public List<ICommand> getCommands() {
		return Collections.unmodifiableList(commandsList);
	}

	private PluginCommand checkCommand(ICommand command) {
		PluginCommand cmd = command.getPlugin().getCommand(command.getLabel());
		if (cmd == null)
			throw new CommandNotFoundException(command.getPlugin(), command.getLabel());
		return cmd;
	}
}
