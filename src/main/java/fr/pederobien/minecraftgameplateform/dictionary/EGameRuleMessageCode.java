package fr.pederobien.minecraftgameplateform.dictionary;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EGameRuleMessageCode implements IMinecraftMessageCode {
	// Code for common tab complete
	MAX_LEVEL__ON_TAB_COMPLETE,

	// Code for common value is missing
	COMMON_VALUE_IS_MISSING, COMMON_VALUE_DEFINED, COMMON_VALUE_DEFINED_IN_GAME,

	// Code for rule pvp
	PVP__EXPLANATION,

	// Code for rule displayTeamMatesLocation
	DISPLAY_CURRENT_TEAMMATES_LOCATION__EXPLANATION,

	// Code for rule enchant
	ENCHANT__CANNOT_ENCHANT,

	// Code for rule maxProtectionOnDiamonds
	MAX_PROTECTION_ON_DIAMONDS__EXPLANATION,

	// Code for command reviveNearTeamMate
	REVIVE_NEAR_TEAM_MATE__EXPLANATION;

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
