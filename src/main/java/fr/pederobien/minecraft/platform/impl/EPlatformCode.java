package fr.pederobien.minecraft.platform.impl;

import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.dictionary.interfaces.IPlayerGroup;

public enum EPlatformCode implements IMinecraftCode {
	// Common codes --------------------------------------------------------------

	// Code for the time format completion
	TIME_FORMAT__COMPLETION,

	// Code for the "pvpTime" command --------------------------------------------
	GAME_CONFIG__PVP_TIME__EXPLANATION,

	// Code when the PVP time is missing
	GAME_CONFIG__PVP_TIME__TIME_IS_MISSING,

	// Code when the PVP is enabled from the beginning
	GAME_CONFIG__PVP_TIME__PVP_ENABLED_FROM_BEGINNING,

	// Code when the PVP is defined
	GAME_CONFIG__PVP_TIME__PVP_TIME_DEFINED,

	// Code for the "ascurrent" command ------------------------------------------
	GAME_CONFIG__AS_CURRENT__EXPLANATION,

	// Code when the game is defined as the game to start
	GAME_CONFIG__AS_CURRENT__GAME_DEFINED,

	;

	private IPlayerGroup group;

	@Override
	public String value() {
		return name();
	}

	@Override
	public IPlayerGroup getGroup() {
		return group;
	}

	@Override
	public void setGroup(IPlayerGroup group) {
		this.group = group;
	}
}
