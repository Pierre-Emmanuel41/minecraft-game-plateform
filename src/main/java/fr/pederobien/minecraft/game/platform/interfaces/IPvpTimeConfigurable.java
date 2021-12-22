package fr.pederobien.minecraft.game.platform.interfaces;

import java.time.LocalTime;

public interface IPvpTimeConfigurable {

	/**
	 * @return A configurable object for the pvp time.
	 */
	IConfigurable<LocalTime> getPvpTime();
}
