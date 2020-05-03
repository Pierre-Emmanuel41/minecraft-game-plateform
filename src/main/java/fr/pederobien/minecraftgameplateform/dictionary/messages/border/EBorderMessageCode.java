package fr.pederobien.minecraftgameplateform.dictionary.messages.border;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum EBorderMessageCode implements IMessageCode {
	// Code for command border
	BORDER__EXPLANATION;

	private Permission permission;

	private EBorderMessageCode() {
		this(Permission.OPERATORS);
	}

	private EBorderMessageCode(Permission permission) {
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
