package fr.pederobien.minecraftgameplateform.dictionary;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public enum EMessageCode implements IMessageCode {
	STARTING_GAME, NO_CONFIGURATION_SETTED;

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
