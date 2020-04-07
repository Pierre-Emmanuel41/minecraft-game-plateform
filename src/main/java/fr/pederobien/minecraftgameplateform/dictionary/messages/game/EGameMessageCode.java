package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftgameplateform.dictionary.Permission;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public enum EGameMessageCode implements IMessageCode {
	// Code for game messages
	STARTING_GAME, NO_CONFIGURATION_SETTED, PAUSING_GAME;

	private Permission permission;

	private EGameMessageCode() {
		this(Permission.OPERATORS);
	}

	private EGameMessageCode(Permission permission) {
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
