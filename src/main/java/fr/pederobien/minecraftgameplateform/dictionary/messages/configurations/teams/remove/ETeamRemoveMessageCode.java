package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum ETeamRemoveMessageCode implements IMessageCode {
	// Code for command remove team
	REMOVE_TEAM__EXPLANATION, REMOVE_TEAM__ALL_TEAMS_REMOVED(Permission.ALL), REMOVE_TEAM__TEAM_DOES_NOT_EXIST, REMOVE_TEAM__ANY_TEAM_REMOVED,
	REMOVE_TEAM__ONE_TEAM_REMOVED(Permission.ALL), REMOVE_TEAM__SEVERAL_TEAMS_REMOVED(Permission.ALL),

	// Code for command remove player
	REMOVE_PLAYER__EXPLANATION, REMOVE_PLAYER__ALL_PLAYERS_REMOVED, REMOVE_PLAYER__ANY_PLAYER_REMOVED, REMOVE_PLAYER__ONE_PLAYER_REMOVED,
	REMOVE_PLAYER__SEVERAL_PLAYERS_REMOVED;

	private Permission permission;

	private ETeamRemoveMessageCode() {
		this(Permission.OPERATORS);
	}

	private ETeamRemoveMessageCode(Permission permission) {
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
