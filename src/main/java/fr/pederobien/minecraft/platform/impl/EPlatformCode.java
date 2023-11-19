package fr.pederobien.minecraft.platform.impl;

import fr.pederobien.minecraft.dictionary.impl.PlayerGroup;
import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.dictionary.interfaces.IPlayerGroup;

public enum EPlatformCode implements IMinecraftCode {
	// Common codes --------------------------------------------------------------

	// Code when the name starts with default
	NAME_MUST_NOT_START_WITH_DEFAULT,

	// Code when the deserialization fails
	FAIL_TO_LOAD,

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

	// Code for the elapsed time since the beginning of the game
	ENTRY__TOTAL_TIME,

	// Code for the time elapsed while the game is paused
	ENTRY__PAUSE_TIME,

	// Code for the time elapsed while the game is in progress
	ENTRY__GAME_TIME,

	// Code to display X, Y and Z coordinates
	ENTRY__X_Y_Z

	;

	private IPlayerGroup group;

	private EPlatformCode() {
		this(PlayerGroup.OPERATORS);
	}

	private EPlatformCode(IPlayerGroup group) {
		this.group = group;
	}

	@Override
	public String getCode() {
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

	@Override
	public String toString() {
		return String.format("value=%s, group=%s", getCode(), getGroup());
	}
}
