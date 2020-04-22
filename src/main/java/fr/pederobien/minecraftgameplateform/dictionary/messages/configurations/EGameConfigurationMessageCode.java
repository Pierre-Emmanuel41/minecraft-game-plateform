package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftdictionary.impl.Permission;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;

public enum EGameConfigurationMessageCode implements IMessageCode {
	// Code for command ascurrent
	AS_CURRENT__EXPLANATION;

	private Permission permission;

	private EGameConfigurationMessageCode() {
		this(Permission.OPERATORS);
	}

	private EGameConfigurationMessageCode(Permission permission) {
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