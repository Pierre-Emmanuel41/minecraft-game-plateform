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
	LOAD_BORDER__EXPLANATION, LOAD_BORDER__NAME_IS_MISSING, LOAD_BORDER__BORDER_LOADED,

	// Code for command delete
	DELETE_BORDER__EXPLANATION, DELETE_BORDER__NAME_IS_MISSING, DELETE_BORDER__DID_NOT_DELETED, DELETE_BORDER__BORDER_DELETED,

	// Code for command list
	LIST_BORDER__EXPLANATION, LIST_BORDER__NO_ELEMENT, LIST_BORDER__ONE_ELEMENT, LIST_BORDER__SEVERAL_ELEMENTS,

	// Code for command rename
	RENAME_BORDER__EXPLANATION, RENAME_BORDER__NAME_IS_MISSING, RENAME_BORDER__NAME_ALREADY_TAKEN, RENAME_BORDER__BORDER_RENAMED,

	// Code for command save
	SAVE_BORDER__EXPLANATION, SAVE_BORDER__BORDER_SAVED,

	// Code for command world
	WORLD_BORDER__EXPLANATION, WORLD_BORDER__WORLD_NAME_IS_MISSING, WORLD_BORDER__WORLD_DEFINED,

	// Code for command center
	CENTER_BORDER__EXPLANATION, CENTER_BORDER__CENTER_DEFINED,

	// Code for command initialDiameter
	INITIAL_BORDER_DIAMETER__EXPLANATION, INITIAL_BORDER_DIAMETER__ON_TAB_COMPLETE, INITIAL_BORDER_DIAMETER__DIAMETER_IS_MISSING,
	INITIAL_BORDER_DIAMETER__NEGATIVE_DIAMETER, INITIAL_BORDER_DIAMETER__DIAMETER_DEFINED,

	// Code for command finalDiameter
	FINAL_BORDER_DIAMETER__EXPLANATION, FINAL_BORDER_DIAMETER__ON_TAB_COMPLETE, FINAL_BORDER_DIAMETER__DIAMETER_IS_MISSING, FINAL_BORDER_DIAMETER__NEGATIVE_DIAMETER,
	FINAL_BORDER_DIAMETER__DIAMETER_DEFINED,

	// Code for command speed
	SPEED_BORDER__EXPLANATION;

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
