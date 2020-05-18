package fr.pederobien.minecraftgameplateform.dictionary;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EGameMessageCode implements IMinecraftMessageCode {
	// Code for game messages
	STARTING_GAME, NO_CONFIGURATION_SETTED, PAUSING_GAME, RESUMING_GAME, STOPPING_GAME;

	private Permission permission;

	private EGameMessageCode() {
		this(Permission.OPERATORS);
	}

	private EGameMessageCode(Permission permission) {
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
