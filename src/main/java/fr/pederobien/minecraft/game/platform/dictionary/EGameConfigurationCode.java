package fr.pederobien.minecraft.game.platform.dictionary;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EGameConfigurationCode implements IMinecraftMessageCode {
	// Code for command ascurrent
	AS_CURRENT__EXPLANATION, AS_CURRENT__GAME_STYLE_DEFINED,

	// Code for command load
	COMMON_LOAD__CONFIGURATION_DOES_NOT_EXIST,

	// Code for command pvpTime
	PVP_TIME__EXPLANATION, PVP_TIME__TIME_IS_MISSING, PVP_TIME__PVP_ENABLED_AT_THE_BEGINNING, PVP_TIME__TIME_DEFINED;

	private Permission permission;

	private EGameConfigurationCode() {
		this(Permission.OPERATORS);
	}

	private EGameConfigurationCode(Permission permission) {
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