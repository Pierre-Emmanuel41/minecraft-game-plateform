package fr.pederobien.minecraft.gameplateform.dictionary;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public enum EPlateformMessageCode implements IMinecraftMessageCode {
	// Code for command pltf
	PLATEFORM__EXPLANATION,

	// Code for command rule
	RULES__EXPLANATION;

	private Permission permission;

	private EPlateformMessageCode() {
		this(Permission.OPERATORS);
	}

	private EPlateformMessageCode(Permission permission) {
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
