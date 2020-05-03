package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum EBorderMessageCode implements IMessageCode {
	BORDER__EXPLANATION,

	// Code for command new
	NEW_BORDER__EXPLANATION, NEW_BORDER__NAME_IS_MISSING;

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
