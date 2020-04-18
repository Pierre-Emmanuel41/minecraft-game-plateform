package fr.pederobien.minecraftgameplateform.dictionary.messages.game;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum EGameMessageCode implements IMessageCode {
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
	public Permission getPermission() {
		return permission;
	}

	@Override
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
}
