package fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline;

import java.time.LocalTime;

public interface IObsTimeLine {

	/**
	 * Method called by the time line to notify that the time has changed.
	 * 
	 * @param time The current time.
	 */
	void onTime(LocalTime time);
}
