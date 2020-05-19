package fr.pederobien.minecraftgameplateform.dictionary;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EBordersMessageCode implements IMinecraftMessageCode {
	// Code for command borders
	BORDERS__EXPLANATION,

	// Code for command add
	ADD_BORDERS__EXPLANATION, ADD_BORDERS__BORDER_DOES_NOT_EXIST, ADD_BORDERS__BORDER_ALREADY_REGISTERED, ADD_BORDERS__NO_BORDER_ADDED, ADD_BORDERS__ONE_BORDER_ADDED,
	ADD_BORDERS__SEVERAL_BORDERS_ADDED,

	// Code for command remove
	REMOVE_BORDERS__EXPLANATION, REMOVE_BORDERS__BORDER_NOT_REGISTERED, REMOVE_BORDERS__NO_BORDER_REMOVED;

	private Permission permission;

	private EBordersMessageCode() {
		this(Permission.OPERATORS);
	}

	private EBordersMessageCode(Permission permission) {
		this.permission = permission;
	}

	@Override
	public String value() {
		return toString();
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
