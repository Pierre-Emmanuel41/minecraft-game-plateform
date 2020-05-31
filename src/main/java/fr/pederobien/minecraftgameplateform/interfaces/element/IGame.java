package fr.pederobien.minecraftgameplateform.interfaces.element;

public interface IGame {

	/**
	 * @return True if the game is successful initiated, false otherwise.
	 */
	boolean initiate();

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
	 * 
	 */
	<T extends IEventListener> T getListener();

	/**
	 * This method is called when the pvp is enabled. If something has to be done by a special game this method is useful.
	 */
	void onPvpEnabled();
}
