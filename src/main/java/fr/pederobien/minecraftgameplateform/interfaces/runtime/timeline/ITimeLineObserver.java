package fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline;

import java.time.LocalTime;

public interface ITimeLineObserver {

	/**
	 * Method called by the time line to notify that the time has changed.
	 * 
	 * @param time The current time.
	 */
	void timeChanged(LocalTime time);
}
