package fr.pederobien.minecraftgameplateform.dictionary;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public enum EMessageCode implements IMessageCode {
	// Code for game messages
	STARTING_GAME, NO_CONFIGURATION_SETTED,

	// Code for command messages
	HELP_EXPLANATION;

	private Permission permission;

	private EMessageCode() {
		this(Permission.OPERATORS);
	}

	private EMessageCode(Permission permission) {
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
