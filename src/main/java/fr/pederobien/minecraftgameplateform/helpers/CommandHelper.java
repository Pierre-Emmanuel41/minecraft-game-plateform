package fr.pederobien.minecraftgameplateform.helpers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bukkit.command.PluginCommand;

import fr.pederobien.minecraftgameplateform.exceptions.CommandAlreadyRegisteredException;
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

		if (commands.get(command.getLabel()) != null)
			throw new CommandAlreadyRegisteredException(command.getLabel());

		commands.put(command.getLabel(), command);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends IUnmodifiableNominable> Optional<IParentCommand<T>> getCommand(String label) {
		ICommand command = commands.get(label);
		return command == null ? Optional.empty() : Optional.of((IParentCommand<T>) command);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IParentCommand<IUnmodifiableNominable>> getCommands() {
		return commands.values().stream().map(cmd -> (IParentCommand<IUnmodifiableNominable>) cmd).collect(Collectors.toList());
	}

	private PluginCommand checkCommand(ICommand command) {
		PluginCommand cmd = command.getPlugin().getCommand(command.getLabel());
		if (cmd == null)
			throw new CommandNotFoundException(command.getPlugin(), command.getLabel());
		return cmd;
	}
}
