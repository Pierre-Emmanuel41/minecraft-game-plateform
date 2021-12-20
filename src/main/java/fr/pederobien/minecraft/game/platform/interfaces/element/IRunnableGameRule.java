package fr.pederobien.minecraft.game.platform.interfaces.element;

public interface IRunnableGameRule<T> extends IGameRule<T> {

	/**
	 * @return The number of ticks between two runs.
	 */
	long getPeriod();

	/**
	 * Set the number of ticks between two runs.
	 * 
	 * @param period The number of ticks.
	 */
	void setPeriod(long period);

	/**
	 * Start running this game rule.
	 */
	void start();

	/**
	 * Stop running this game rule.
	 */
	void stop();

	/**
	 * @return True if this game rule is running, false otherwise.
	 */
	boolean isRunning();
}
