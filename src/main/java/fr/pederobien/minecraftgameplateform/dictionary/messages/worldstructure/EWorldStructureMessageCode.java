package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EWorldStructureMessageCode implements IMinecraftMessageCode {
	COMMON_DIMENSION__BAD_DIMENSION_FORMAT, COMMON_DIMENSION__MISSING_DIMENSION;

	private Permission permission;

	private EWorldStructureMessageCode() {
		this(Permission.OPERATORS);
	}

	private EWorldStructureMessageCode(Permission permission) {
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
