package fr.pederobien.minecraftgameplateform.dictionary;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EGameConfigurationMessageCode implements IMinecraftMessageCode {
	// Code for command ascurrent
	AS_CURRENT__EXPLANATION, AS_CURRENT__GAME_STYLE_DEFINED,

	// Code for command load
	COMMON_LOAD__CONFIGURATION_DOES_NOT_EXIST,

	// Code for command scoreboardrefresh
	SCOREBOARD_REFRESH__EXPLANATION, SCOREBOARD_REFRESH__ON_TAB_COMPLETE, SCOREBOARD_REFRESH__NEGATIVE_TICS_NUMBER, SCOREBOARD_REFRESH__TICS_NUMBER_IS_MISSING,
	SCOREBOARD_REFRESH__ONE_TICK_DEFINED, SCOREBOARD_REFRESH__SEVERAL_TICS_DEFINED;

	private Permission permission;

	private EGameConfigurationMessageCode() {
		this(Permission.OPERATORS);
	}

	private EGameConfigurationMessageCode(Permission permission) {
		this.permission = permission;
	}

	@Override
	public String value() {
		return toString();
	}

	@Override
	public Permission getPermission() {
		return permission;
	}

	@Override
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
}
