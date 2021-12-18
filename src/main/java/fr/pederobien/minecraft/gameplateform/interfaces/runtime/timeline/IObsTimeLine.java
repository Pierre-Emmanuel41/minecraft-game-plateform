package fr.pederobien.minecraft.gameplateform.interfaces.runtime.timeline;

import java.time.LocalTime;

public interface IObsTimeLine {

	/**
	 * Get the number of seconds before calling method {@link #onTime(LocalTime)}. This means that each second from the countdown to
	 * the onTime this observer is notified throw the method {@link #onCountDownTime(LocalTime)}.
	 * 
	 * @return The number of second before calling method onTime.
	 */
	int getCountDown();

	/**
	 * Get the current number of seconds before calling method {@link #onTime(LocalTime)}. This value should be decreased by one each
	 * time the method {@link #onCountDownTime(LocalTime)} is called and reset when the value equals 0.
	 * 
	 * @return The current number of second before calling method onTime.
	 */
	int getCurrentCountDown();

	/**
	 * Method called by the time line to notify that the time has changed.
	 * 
	 * @param currentTime The current time of the game.
	 */
	void onTime(LocalTime currentTime);

	/**
	 * Notify this observer as a countdown notification.
	 * 
	 * @param currentTime The current time of the game.
	 */
	void onCountDownTime(LocalTime currentTime);

	/**
	 * Get the next time at which this observer should be notified. This time correspond to the absolute time (from the beginning of
	 * the game) at which the observer wants to be notified.. If the returned time corresponds to 0h 0m 0s then this observer will
	 * never be notified again.
	 * 
	 * @return The new time at which this observer will be notified.
	 */
	LocalTime getNextNotifiedTime();
}
