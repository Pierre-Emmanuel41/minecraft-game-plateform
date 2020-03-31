package fr.pederobien.minecraftgameplateform.utils;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.PluginCommand;

import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;

public class CommandHelper {
	private static Map<String, ICommand> commands = new HashMap<String, ICommand>();

	/**
	 * Register this command in order to be executed by this plugin.
	 * 
	 * @param command The command to register.
	 */
	public static void register(ICommand command) {
		PluginCommand cmd = command.getPlugin().getCommand(command.getLabel());
		cmd.setExecutor(command);
		if (command.getTabCompleter() != null)
			cmd.setTabCompleter(command.getTabCompleter());
		commands.put(command.getLabel(), command);
	}

	/**
	 * Set the availability of each registered commands.
	 * 
	 * @param available True if all commands are available, false if all commands are not available.
	 */
	public static void setAllAvailable(boolean available) {
		commands.values().forEach(c -> c.setAvailable(available));
	}

	/**
	 * Set the availability of the command associated to the given label.
	 * 
	 * @param label       The label of the command to modify.
	 * @param isAvailable The new value that represent the availability of this command.
	 * 
	 * @return True if the command has been found, false otherwise.
	 */
	public static boolean setAvailable(String label, boolean available) {
		ICommand cmd = commands.get(label);
		if (cmd != null)
			cmd.setAvailable(available);
		return cmd != null;
	}
}
