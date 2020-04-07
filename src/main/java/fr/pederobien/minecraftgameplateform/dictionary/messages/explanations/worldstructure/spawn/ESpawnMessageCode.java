package fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.Permission;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public enum ESpawnMessageCode implements IMessageCode {
	SPAWN_PARENT_EXPLANATION,

	// Code for command new
	NEW_SPAWN__EXPLANATION, NEW_SPAWN__NAME_IS_MISSING, NEW_SPAWN__NAME_ALREADY_TAKEN, NEW_SPAWN__SPAWN_CREATED,

	// Code for command dimension
	DIMENSION_SPAWN__EXPLANATION, DIMENSION_SPAWN_DEFINED;

	private Permission permission;

	private ESpawnMessageCode() {
		this(Permission.OPERATORS);
	}

	private ESpawnMessageCode(Permission permission) {
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
