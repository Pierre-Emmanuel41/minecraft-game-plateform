package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public enum FrenchSpawnMessages {
	SPAWN_PARENT_EXPLANATION(SpawnParent_Explanation.FRENCH),

	NEW_SPAWN_EXPLANATION(NewSpawn_Explanation.FRENCH),

	NEW_SPAWN_NAME_IS_MISSING(NewSpawn_NameIsMissing.FRENCH),

	NEW_SPAWN_NAME_ALREADY_TAKEN(NewSpawn_NameAlreadyTaken.FRENCH),

	NEW_SPAWN_SPAWN_CREATED(NewSpawn_SpawnCreated.FRENCH),

	WORLD_SPAWN_EXPLANATION(WorldSpawn_Explanation.FRENCH),

	WORLD_SPAWN_WORLD_NAME_IS_MISSING(WorldSpawn_WorldNameIsMissing.FRENCH),

	WORLD_SPAWN_WORLD_DEFINED(WorldSpawn_WorldDefined.FRENCH),

	SPAWN_CENTER_EXPLANATION(CenterSpawn_Explanation.FRENCH),

	SPAWN_CENTER_DEFINED(CenterSpawn_CenterDefined.FRENCH),

	DIMENSION_SPAWN_EXPLANATION(DimensionSpawn_Explanation.FRENCH),

	DIMENSION_SPAWN_DIMENSION_DEFINED(DimensionSpawn_Defined.FRENCH),

	RENAME_SPAWN_EXPLANATION(RenameSpawn_Explanation.FRENCH),

	RENAME_SPAWN_NAME_IS_MISSING(RenameSpawn_NameIsMissing.FRENCH),

	RENAME_SPAWN_NAME_ALREADY_TAKEN(RenameSpawn_NameAlreadyTaken.FRENCH),

	RENAME_SPAWN_SPAWN_RENAMED(RenameSpawn_SpawnRenamed.FRENCH),

	SAVE_SPAWN_EXPLANATION(SaveSpawn_Explanation.FRENCH),

	SAVE_SPAWN_SPAWN_SAVED(SaveSpawn_SpawnSaved.FRENCH),

	LIST_SPAWN_EXPLANATION(ListSpawn_Explanation.FRENCH),

	LIST_SPAWN_NO_ELEMENT(ListSpawn_NoElement.FRENCH),

	LIST_SPAWN_ONE_ELEMENT(ListSpawn_OneElement.FRENCH),

	LIST_SPAWN_SEVERAL_ELEMENTS(ListSpawn_SeveralElements.FRENCH),

	DELETE_SPAWN_EXPLANATION(DeleteSpawn_Explanation.FRENCH),

	DELETE_SPAWN_NAME_IS_MISSING(DeleteSpawn_NameIsMissing.FRENCH),

	DELETE_SPAWN_SPAWN_DID_NOT_DELETE(DeleteSpawn_DidNotDelete.FRENCH),

	DELETE_SPAWN_SPAWN_DELETED(DeleteSpawn_SpawnDeleted.FRENCH),

	EXTRACT_SPAWN_EXPLANATION(ExtractSpawn_Explanation.FRENCH),

	EXTRACT_SPAWN_SPAWN_EXTRACTED(ExtractSpawn_SpawnExtracted.FRENCH),

	REMOVE_SPAWN_EXPLANATION(RemoveSpawn_Explanation.FRENCH),

	REMOVE_SPAWN_SPAWN_REMOVED(RemoveSpawn_SpawnRemoved.FRENCH),

	LAUNCH_SPAWN_EXPLANATION(LaunchSpawn_Explanation.FRENCH),

	LAUNCH_SPAWN_NO_CURRENT_SPAWN(LaunchSpawn_NoCurrentSpawn.FRENCH),

	LAUNCH_SPAWN_WORLD_IS_MISSING(LaunchSpawn_WorldIsMissing.FRENCH),

	LAUNCH_SPAWN_SPAWN_DOES_NOT_EXIST(LaunchSpawn_SpawnDoesNotExist.FRENCH),

	LAUNCH_SPAWN_SPAWN_LAUNCHED(LaunchSpawn_SpawnLaunched.FRENCH),

	CURRENT_SPAWN_EXPLANATION(CurrentSpawn_Explanation.FRENCH),

	CURRENT_SPAWN_ON_CURRENT(CurrentSpawn_OnCurrent.FRENCH),

	PLAYER_SPAWN_EXPLANATION(PlayerSpawn_Explanation.FRENCH),

	PLAYER_SPAWN_PLAYER_SPAWN_DEFINED(PlayerSpawn_PlayerSpawnDefined.FRENCH),

	RANDOM_SPAWN_EXPLANATION(RandomSpawn_Explanation.FRENCH),

	RANDOM_SPAWN_WORLD_OR_COORDINATES_ARE_MISSING(RandomSpawn_WorldOrCoordinatesAreMissing.FRENCH),

	ALLOW_MOBS_TO_SPAWN_UNDER_SPAWN_EXPLANATION(AllowMobsToSpawnUnderSpawn_Explanation.FRENCH),

	ALLOW_MOB_TO_SPAWN_UNDER_SPAWN_VALUE_IS_MISSING(AllowMobsToSpawnUnderSpawn_ValueIsMissing.FRENCH),

	ALLOW_MOB_TO_SPAWN_UNDER_SPAWN_DEFINED(AllowMobsToSpawnUnderSpawn_Defined.FRENCH);

	private IMinecraftMessage source;

	private FrenchSpawnMessages(IMinecraftMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (FrenchSpawnMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMinecraftMessage getSource() {
		return source;
	}
}
