package fr.pederobien.minecraftgameplateform.interfaces.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;

public interface ICommand extends CommandExecutor {

	/**
	 * @return The plugin to which this command is associated.
	 */
	Plugin getPlugin();

	/**
	 * @return The label of this command.
	 */
	String getCommand();
}
