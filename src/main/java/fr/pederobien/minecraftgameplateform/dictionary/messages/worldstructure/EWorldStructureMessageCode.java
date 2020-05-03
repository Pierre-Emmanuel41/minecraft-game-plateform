package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum EWorldStructureMessageCode implements IMessageCode {
	COMMON_DIMENSION__BAD_DIMENSION_FORMAT, COMMON_DIMENSION__MISSING_DIMENSION,

	COMMON_WORLD__WORLD_DOES_NOT_EXIST;

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
