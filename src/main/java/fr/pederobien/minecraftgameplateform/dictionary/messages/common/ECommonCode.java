package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.Permission;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public enum ECommonCode implements IMessageCode {
	COMMON_BAD_COORDINATES_FORMAT, COMMON_MISSING_COORDINATES,

	// Code for common configuration command messages
	COMMON_NEW_TAB_COMPLETE;

	private Permission permission;

	private ECommonCode() {
		this(Permission.OPERATORS);
	}

	private ECommonCode(Permission permission) {
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
