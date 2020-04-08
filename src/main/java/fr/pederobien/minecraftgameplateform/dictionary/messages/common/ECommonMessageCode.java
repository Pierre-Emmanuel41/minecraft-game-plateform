package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftgameplateform.dictionary.Permission;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public enum ECommonMessageCode implements IMessageCode {
	COMMON_BAD_INTEGER_FORMAT, COMMON_ARGUMENT_NOT_FOUND, COMMON_NOT_AVAILABLE_ARGUMENT, COMMON_NOT_AVAILABLE_COMMAND, COMMON_NAME_MUST_NOT_START_WITH_DEFAULT,

	// Code for common new command messages
	COMMON_NEW__TAB_COMPLETE,

	// Code for common rename command messages
	COMMON_RENAME__TAB_COMPLETE;

	private Permission permission;

	private ECommonMessageCode() {
		this(Permission.OPERATORS);
	}

	private ECommonMessageCode(Permission permission) {
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
