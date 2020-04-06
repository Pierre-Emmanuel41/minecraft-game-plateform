package fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure;

import fr.pederobien.minecraftgameplateform.dictionary.Permission;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public enum EWorldStructureMessageCode implements IMessageCode {
	COMMON_CENTER_EXPLANATION, COMMON_CENTER__CENTER_DEFINED;

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
