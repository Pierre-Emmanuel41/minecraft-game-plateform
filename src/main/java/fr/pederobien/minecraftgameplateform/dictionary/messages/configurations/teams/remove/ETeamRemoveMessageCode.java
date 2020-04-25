package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum ETeamRemoveMessageCode implements IMessageCode {
	// Code command remove team
	REMOVE_TEAM__EXPLANATION, REMOVE_TEAM__ALL_TEAMS_REMOVED, REMOVE_TEAM__TEAM_DOES_NOT_EXIST, REMOVE_TEAM__ANY_TEAM_REMOVED, REMOVE_TEAM__ONE_TEAM_REMOVED;

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
