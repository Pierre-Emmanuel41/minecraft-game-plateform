package fr.pederobien.minecraftgameplateform.dictionary;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EGameRuleMessageCode implements IMinecraftMessageCode {
	// Code for command pvp
	PVP__EXPLANATION, PVP__VALUE_IS_MISSING, PVP__VALUE_DEFINED,

	// Code for command displayTeamMatesLocation
	DISPLAY_CURRENT_TEAMMATES_LOCATION__EXPLANATION, DISPLAY_CURRENT_TEAMMATES_LOCATION__VALUE_IS_MISSING, DISPLAY_CURRENT_TEAMMATES_LOCATION__VALUE_DEFINED;

	private Permission permission;

	private EGameRuleMessageCode() {
		this(Permission.OPERATORS);
	}

	private EGameRuleMessageCode(Permission permission) {
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
