package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum ETeamAddMessageCode implements IMessageCode {
	// Code for command add team
	ADD_TEAM__EXPLANATION, ADD_TEAM__TEAM_NAME_IS_MISSING, ADD_TEAM__COLOR_NAME_IS_MISSING, ADD_TEAM__COLOR_DOES_NOT_EXIST, ADD_TEAM__TEAM_NAME_FORBIDDEN,
	ADD_TEAM__TEAM_NAME_ALREADY_USED, ADD_TEAM__COLOR_ALREADY_USED, ADD_TEAM__TEAM_ADDED,

	// Code for command add player
	ADD_PLAYER__ANY_PLAYER_ADDED, ADD_PLAYER__ONE_PLAYER_ADDED;

	private Permission permission;

	private ETeamAddMessageCode() {
		this(Permission.ALL);
	}

	private ETeamAddMessageCode(Permission permission) {
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
