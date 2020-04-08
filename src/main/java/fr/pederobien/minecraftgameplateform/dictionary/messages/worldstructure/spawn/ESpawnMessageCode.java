package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.Permission;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public enum ESpawnMessageCode implements IMessageCode {
	SPAWN_PARENT_EXPLANATION,

	// Code for command new
	NEW_SPAWN__EXPLANATION, NEW_SPAWN__NAME_IS_MISSING, NEW_SPAWN__NAME_ALREADY_TAKEN, NEW_SPAWN__SPAWN_CREATED,

	// Code for command dimension
	DIMENSION_SPAWN__EXPLANATION, DIMENSION_SPAWN__DEFINED,

	// Code for command rename
	RENAME_SPAWN__EXPLANATION, RENAME_SPAWN__NAME_IS_MISSING, RENAME_SPAWN__NAME_ALREADY_TAKEN, RENAME_SPAWN__SPAWN_RENAMED,

	// Code for command save
	SAVE_SPAWN__EXPLANATION, SAVE_SPAWN__SPAWN_SAVED,

	// Code for command list
	LIST_SPAWN__EXPLANATION;
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
