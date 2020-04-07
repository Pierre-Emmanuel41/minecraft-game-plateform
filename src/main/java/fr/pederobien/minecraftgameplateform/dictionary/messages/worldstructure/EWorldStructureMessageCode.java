package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.Permission;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public enum EWorldStructureMessageCode implements IMessageCode {
	// Code for common center command messages
	COMMON_CENTER__EXPLANATION, COMMON_CENTER__CENTER_DEFINED,

	// Code for common dimension command messages
	COMMON_DIMENSION__BAD_DIMENSION_FORMAT, COMMON_DIMENSION__MISSING_DIMENSION;

	private Permission permission;

	private EWorldStructureMessageCode() {
		this(Permission.OPERATORS);
	}

	private EWorldStructureMessageCode(Permission permission) {
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
