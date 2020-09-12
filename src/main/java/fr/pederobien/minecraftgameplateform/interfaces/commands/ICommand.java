package fr.pederobien.minecraftgameplateform.interfaces.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGame;

public interface ICommand extends CommandExecutor {

	/**
	 * @return The plugin to which this command is associated.
	 */
	JavaPlugin getPlugin();

	/**
	 * @return The label of this command.
	 */
	String getLabel();

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

	/**
	 * @return The tab completer associated to this command. It could be null.
	 */
	TabCompleter getTabCompleter();

	/**
	 * Method called just before starting a game.
	 * 
	 * @param IGame The starting game.
	 * 
	 * @return True if the game can be started, false otherwise.
	 */
	<U extends IGame> boolean onGameIsStarting(U IGame);

	/**
	 * Method called just after starting a game.
	 * 
	 * @param IGame The started game.
	 */
	<U extends IGame> void onGameIsStarted(U IGame);

	/**
	 * Method called just before pausing a game.
	 * 
	 * @param IGame The pausing game.
	 * 
	 * @return True if the game can be paused, false otherwise.
	 */
	<U extends IGame> boolean onGameIsPausing(U IGame);

	/**
	 * Method called just after pausing a game.
	 * 
	 * @param IGame The paused game.
	 */
	<U extends IGame> void onGameIsPaused(U IGame);

	/**
	 * Method called just before resuming a game.
	 * 
	 * @param IGame The resuming game.
	 * 
	 * @return True if the game can be resumed, false otherwise.
	 */
	<U extends IGame> boolean onGameIsResuming(U IGame);

	/**
	 * Method called just after resuming a game.
	 * 
	 * @param IGame The resumed game.
	 */
	<U extends IGame> void onGameIsResumed(U IGame);

	/**
	 * Method called just before stopping a game.
	 * 
	 * @param IGame The stopping game.
	 * 
	 * @return True if the game can be stopped, false otherwise.
	 */
	<U extends IGame> boolean onGameIsStopping(U IGame);

	/**
	 * Method called just after stopping a game.
	 * 
	 * @param IGame The stopped game.
	 */
	<U extends IGame> void onGameIsStopped(U IGame);
}
