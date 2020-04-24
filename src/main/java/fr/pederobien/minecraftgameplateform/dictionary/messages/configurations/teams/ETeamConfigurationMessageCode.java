package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum ETeamConfigurationMessageCode implements IMessageCode {
	// Code for command add
	ADD__EXPLANATION,

	// Code for command remove
	REMOVE__EXPLANATION,

	// Code for command to add a player to a team
	ADD_PLAYER__PLAYER_DOES_NOT_EXIST;

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
