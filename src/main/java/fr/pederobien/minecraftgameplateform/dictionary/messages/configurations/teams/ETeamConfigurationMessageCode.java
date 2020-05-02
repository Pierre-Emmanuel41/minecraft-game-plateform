package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum ETeamConfigurationMessageCode implements IMessageCode {
	// Code for command team
	TEAM__EXPLANATION,

	// Code for command add
	ADD__EXPLANATION,

	// Code for command remove
	REMOVE__EXPLANATION,

	// Code for command modify
	MODIFY__EXPLANATION,

	// Code for command list
	LIST__EXPLANATION, LIST__ANY_EXISTING_TEAM, LIST__ONE_EXISTING_TEAM, LIST__SEVERAL_EXISTING_TEAMS,

	// Code for command move
	MOVE__EXPLANATION, MOVE__PLAYER_NAME_IS_MISSING, MOVE__TEAM_NAME_IS_MISSING, MOVE__PLAYER_DOES_NOT_EXIST, MOVE__PLAYER_NOT_REGISTERED, MOVE__TEAM_DOES_NOT_EXIST;

	private Permission permission;

	private ETeamConfigurationMessageCode() {
		this(Permission.OPERATORS);
	}

	private ETeamConfigurationMessageCode(Permission permission) {
		this.permission = permission;
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
