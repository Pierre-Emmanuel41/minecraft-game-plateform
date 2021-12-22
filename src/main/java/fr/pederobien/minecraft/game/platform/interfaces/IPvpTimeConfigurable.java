package fr.pederobien.minecraft.game.platform.interfaces;

import java.time.LocalTime;

import fr.pederobien.minecraft.game.interfaces.IGameConfiguration;

public interface IPvpTimeConfigurable extends IGameConfiguration {

	/**
	 * @return A configurable object for the pvp time.
	 */
	IConfigurable<LocalTime> getPvpTime();
}
