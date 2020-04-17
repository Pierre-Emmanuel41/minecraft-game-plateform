package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.Permission;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;

public enum ESpawnMessageCode implements IMessageCode {
	SPAWN_PARENT_EXPLANATION,

	// Code for command new
	NEW_SPAWN__EXPLANATION, NEW_SPAWN__NAME_IS_MISSING, NEW_SPAWN__NAME_ALREADY_TAKEN, NEW_SPAWN__SPAWN_CREATED,

	// Code for command world
	WORLD_SPAWN__EXPLANATION, WORLD_SPAWN__WORLD_NAME_IS_MISSING, WORLD_SPAWN__WORLD_DEFINED,

	// Code for command center
	CENTER_SPAWN__EXPLANATION, CENTER_SPAWN__CENTER_DEFINED,

	// Code for command dimension
	DIMENSION_SPAWN__EXPLANATION, DIMENSION_SPAWN__DEFINED,

	// Code for command rename
	RENAME_SPAWN__EXPLANATION, RENAME_SPAWN__NAME_IS_MISSING, RENAME_SPAWN__NAME_ALREADY_TAKEN, RENAME_SPAWN__SPAWN_RENAMED,

	// Code for command save
	SAVE_SPAWN__EXPLANATION, SAVE_SPAWN__SPAWN_SAVED,

	// Code for command list
	LIST_SPAWN__EXPLANATION, LIST_SPAWN__NO_ELEMENT, LIST_SPAWN__ONE_ELEMENT, LIST_SPAWN__SEVERAL_ELEMENTS,

	// Code for command delete
	DELETE_SPAWN__EXPLANATION, DELETE_SPAWN__NAME_IS_MISSING, DELETE_SPAWN__SPAWN_DELETED, DELETE_SPAWN__DIT_NOT_DELETE,

	// Code for command extract
	EXTRACT_SPAWN__EXPLANATION, EXTRACT_SPAWN__SPAWN_EXTRACTED,

	// Code for command remove
	REMOVE_SPAWN__EXPLANATION, REMOVE_SPAWN__SPAWN_REMOVED,

	// Code for command launch
	LAUNCH_SPAWN__EXPLANATION, LAUNCH_SPAWN__NO_CURRENT_SPAWN, LAUNCH_SPAWN__WORLD_IS_MISSING, LAUNCH_SPAWN__SPAWN_DOES_NOT_EXIST, LAUNCH_SPAWN__SPAWN_LAUNCHED,

	// Code for command current
	CURRENT_SPAWN__EXPLANATION, CURRENT_SPAWN__ON_CURRENT,

	// Code for command player spawn
	PLAYER_SPAWN__EXPLANATION, PLAYER_SPAWN__PLAYER_SPAWN_DEFINED,

	// Code for command random
	RANDOM_SPAWN__EXPLANATION, RANDOM_SPAWN__WORLD_OR_COORDINATES_ARE_MISSING;

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
