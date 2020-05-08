package fr.pederobien.minecraftgameplateform.border.messages;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum EBorderMessageCode implements IMessageCode {
	BORDER__EXPLANATION,

	// Code for command new
	NEW_BORDER__EXPLANATION, NEW_BORDER__NAME_IS_MISSING, NEW_BORDER__NAME_ALREADY_TAKEN, NEW_BORDER__BORDER_CREATED,

	// Code for command current
	CURRENT_BORDER__EXPLANATION, CURRENT_BORDER__ON_CURRENT,

	// Code for command load
	LOAD_BORDER__EXPLANATION,

	// Code for command delete
	DELETE_BORDER__EXPLANATION, DELETE_BORDER__NAME_IS_MISSING, DELETE_BORDER__DID_NOT_DELETED, DELETE_BORDER__BORDER_DELETED,

	// Code for command list
	LIST_BORDER__EXPLANATION, LIST_BORDER__NO_ELEMENT, LIST_BORDER__ONE_ELEMENT, LIST_BORDER__SEVERAL_ELEMENTS,

	// Code for command world
	WORLD_BORDER__EXPLANATION, WORLD_BORDER__WORLD_NAME_IS_MISSING, WORLD_BORDER__WORLD_DEFINED;

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
