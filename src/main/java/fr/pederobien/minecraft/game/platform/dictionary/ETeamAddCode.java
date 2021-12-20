package fr.pederobien.minecraft.game.platform.dictionary;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum ETeamAddCode implements IMinecraftMessageCode {
	// Code for command add team
	ADD_TEAM__EXPLANATION, ADD_TEAM__TEAM_NAME_IS_MISSING, ADD_TEAM__COLOR_NAME_IS_MISSING, ADD_TEAM__COLOR_DOES_NOT_EXIST, ADD_TEAM__TEAM_NAME_FORBIDDEN,
	ADD_TEAM__TEAM_NAME_ALREADY_USED, ADD_TEAM__COLOR_ALREADY_USED, ADD_TEAM__TEAM_ADDED(Permission.ALL),

	// Code for command add player
	ADD_PLAYER__EXPLANATION, ADD_PLAYER__TEAM_NAME_IS_MISSING, ADD_PLAYER__TEAM_DOES_NOT_EXIST, ADD_PLAYER__PLAYER_ALREADY_REGISTERED,
	ADD_PLAYER__ANY_PLAYER_ADDED(Permission.ALL), ADD_PLAYER__ONE_PLAYER_ADDED(Permission.ALL), ADD_PLAYER__SEVERAL_PLAYERS_ADDED(Permission.ALL);

	private Permission permission;

	private ETeamAddCode() {
		this(Permission.OPERATORS);
	}

	private ETeamAddCode(Permission permission) {
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
