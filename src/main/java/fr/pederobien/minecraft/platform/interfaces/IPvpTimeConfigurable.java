package fr.pederobien.minecraft.platform.interfaces;

import java.time.LocalTime;

public interface IPvpTimeConfigurable {

	/**
	 * @return A configurable object for the pvp time.
	 */
	IConfigurable<LocalTime> getPvpTime();
}
