package fr.pederobien.minecraftgameplateform.interfaces.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public interface ICommand extends CommandExecutor {

	/**
	 * @return The plugin to which this command is associated.
	 */
	JavaPlugin getPlugin();

	/**
	 * @return The label of this command.
	 */
	String getCommand();

	/**
	 * @return true if this command is available, false otherwise.
	 */
	boolean isAvailable();

	/**
	 * Set the availability of this command.
	 * 
	 * @param isAvailable The new value that represent the availability of this command.
	 */
	void setAvailable(boolean isAvailable);
}
