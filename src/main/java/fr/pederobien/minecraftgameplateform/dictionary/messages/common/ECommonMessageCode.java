package fr.pederobien.minecraftgameplateform.dictionary.messages.common;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum ECommonMessageCode implements IMessageCode {
	COMMON_HELP__EXPLANATION,

	COMMON_BAD_INTEGER_FORMAT, COMMON__BAD_BOOLEAN_FORMAT, COMMON_ARGUMENT_NOT_FOUND, COMMON_NOT_AVAILABLE_ARGUMENT, COMMON_NOT_AVAILABLE_COMMAND,
	COMMON_NAME_MUST_NOT_START_WITH_DEFAULT, COMMON_MISSING_COORDINATES,

	// Code for common new command messages
	COMMON_NEW__TAB_COMPLETE,

	// Code for common rename command messages
	COMMON_RENAME__TAB_COMPLETE,

	// Code for common exception messages
	COMMON__PLAYER_DOES_NOT_EXIST;

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
