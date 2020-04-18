package fr.pederobien.minecraftgameplateform.dictionary.messages;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum EMessageCode implements IMessageCode {
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
