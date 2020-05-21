package fr.pederobien.minecraftgameplateform.interfaces.commands;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGame;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface IParentCommand<T extends IUnmodifiableNominable> extends ICommand {

	/**
	 * @return The parent that contains all registered editions for this command.
	 */
	IParentPersistenceEdition<T> getParent();

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
