package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.Permission;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public enum ECommonCode implements IMessageCode {
	COMMON_BAD_INTEGER_FORMAT,

	// Code for common new command messages
	COMMON_NEW__TAB_COMPLETE, COMMON_NEW__NAME_MUST_NOT_START_WITH_DEFAULT,

	// Code for common rename command messages
	COMMON_RENAME__TAB_COMPLETE;

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
