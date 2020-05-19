package fr.pederobien.minecraftgameplateform.dictionary;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EBordersMessageCode implements IMinecraftMessageCode {
	// Code for command borders
	BORDERS__EXPLANATION,

	// Code for command add
	BORDERS_ADD__EXPLANATION, BORDERS_ADD__BORDER_DOES_NOT_EXIST;

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
