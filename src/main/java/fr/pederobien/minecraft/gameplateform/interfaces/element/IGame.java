package fr.pederobien.minecraft.gameplateform.interfaces.element;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.gameplateform.interfaces.editions.IPlateformCodeSender;

public interface IGame extends IPlateformCodeSender {

	/**
	 * Initialize this game.
	 * 
	 * @param sender  Source of the command
	 * @param command Command which was executed
	 * @param label   Alias of the command which was used
	 * @param args    Passed command arguments
	 * @return True if the game is successful initiated, false otherwise.
	 */
	boolean initiate(CommandSender sender, Command command, String label, String[] args);

	/**
	 * Method called to start the game.
	 */
	void start();

	/**
	 * Method called to stop a game.
	 */
	void stop();

	/**
	 * Method called to pause the game.
	 */
	void pause();

	/**
	 * Method called to relaunch the game when it is in pause.
	 */
	void relaunch();

	/**
	 * @return The listener that interact with minecraft events.
	 */
	IEventListener getListener();

	/**
	 * This method is called when the pvp is enabled. If something has to be done by a special game this method is useful.
	 */
	void onPvpEnabled();

	/**
	 * @return True if the game has been started, false otherwise.
	 */
	boolean isRunning();
}
