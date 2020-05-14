package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public enum EnglishSpawnMessages {
	SPAWN_PARENT_EXPLANATION(SpawnParent_Explanation.ENGLISH),

	NEW_SPAWN_EXPLANATION(NewSpawn_Explanation.ENGLISH),

	NEW_SPAWN_NAME_IS_MISSING(NewSpawn_NameIsMissing.ENGLISH),

	NEW_SPAWN_NAME_ALREADY_TAKEN(NewSpawn_NameAlreadyTaken.ENGLISH),

	NEW_SPAWN_SPAWN_CREATED(NewSpawn_SpawnCreated.ENGLISH),

	WORLD_SPAWN_EXPLANATION(WorldSpawn_Explanation.ENGLISH),

	WORLD_SPAWN_WORLD_NAME_IS_MISSING(WorldSpawn_WorldNameIsMissing.ENGLISH),

	WORLD_SPAWN_WORLD_DEFINED(WorldSpawn_WorldDefined.ENGLISH),

	SPAWN_CENTER_EXPLANATION(CenterSpawn_Explanation.ENGLISH),

	SPAWN_CENTER_DEFINED(CenterSpawn_CenterDefined.ENGLISH),

	DIMENSION_SPAWN_EXPLANATION(DimensionSpawn_Explanation.ENGLISH),

	DIMENSION_SPAWN_DIMENSION_DEFINED(DimensionSpawn_Defined.ENGLISH),

	RENAME_SPAWN_EXPLANATION(RenameSpawn_Explanation.ENGLISH),

	RENAME_SPAWN_NAME_IS_MISSING(RenameSpawn_NameIsMissing.ENGLISH),

	RENAME_SPAWN_NAME_ALREADY_TAKEN(RenameSpawn_NameAlreadyTaken.ENGLISH),

	RENAME_SPAWN_SPAWN_RENAMED(RenameSpawn_SpawnRenamed.ENGLISH),

	SAVE_SPAWN_EXPLANATION(SaveSpawn_Explanation.ENGLISH),

	SAVE_SPAWN_SPAWN_SAVED(SaveSpawn_SpawnSaved.ENGLISH),

	LIST_SPAWN_EXPLANATION(ListSpawn_Explanation.ENGLISH),

	LIST_SPAWN_NO_ELEMENT(ListSpawn_NoElement.ENGLISH),

	LIST_SPAWN_ONE_ELEMENT(ListSpawn_OneElement.ENGLISH),

	LIST_SPAWN_SEVERAL_ELEMENTS(ListSpawn_SeveralElements.ENGLISH),

	DELETE_SPAWN_EXPLANATION(DeleteSpawn_Explanation.ENGLISH),

	DELETE_SPAWN_NAME_IS_MISSING(DeleteSpawn_NameIsMissing.ENGLISH),

	DELETE_SPAWN_SPAWN_DID_NOT_DELETE(DeleteSpawn_DidNotDelete.ENGLISH),

	DELETE_SPAWN_SPAWN_DELETED(DeleteSpawn_SpawnDeleted.ENGLISH),

	EXTRACT_SPAWN_EXPLANATION(ExtractSpawn_Explanation.ENGLISH),

	EXTRACT_SPAWN_SPAWN_EXTRACTED(ExtractSpawn_SpawnExtracted.ENGLISH),

	REMOVE_SPAWN_EXPLANATION(RemoveSpawn_Explanation.ENGLISH),

	REMOVE_SPAWN_SPAWN_REMOVED(RemoveSpawn_SpawnRemoved.ENGLISH),

	LAUNCH_SPAWN_EXPLANATION(LaunchSpawn_Explanation.ENGLISH),

	LAUNCH_SPAWN_NO_CURRENT_SPAWN(LaunchSpawn_NoCurrentSpawn.ENGLISH),

	LAUNCH_SPAWN_WORLD_IS_MISSING(LaunchSpawn_WorldIsMissing.ENGLISH),

	LAUNCH_SPAWN_SPAWN_DOES_NOT_EXIST(LaunchSpawn_SpawnDoesNotExist.ENGLISH),

	LAUNCH_SPAWN_SPAWN_LAUNCHED(LaunchSpawn_SpawnLaunched.ENGLISH),

	CURRENT_SPAWN_EXPLANATION(CurrentSpawn_Explanation.ENGLISH),

	CURRENT_SPAWN_ON_CURRENT(CurrentSpawn_OnCurrent.ENGLISH),

	PLAYER_SPAWN_EXPLANATION(PlayerSpawn_Explanation.ENGLISH),

	PLAYER_SPAWN_PLAYER_SPAWN_DEFINED(PlayerSpawn_PlayerSpawnDefined.ENGLISH),

	RANDOM_SPAWN_EXPLANATION(RandomSpawn_Explanation.ENGLISH),

	RANDOM_SPAWN_WORLD_OR_COORDINATES_ARE_MISSING(RandomSpawn_WorldOrCoordinatesAreMissing.ENGLISH),

	ALLOW_MOBS_TO_SPAWN_UNDER_SPAWN_EXPLANATION(AllowMobsToSpawnUnderSpawn_Explanation.ENGLISH),

	ALLOW_MOB_TO_SPAWN_UNDER_SPAWN_VALUE_IS_MISSING(AllowMobsToSpawnUnderSpawn_ValueIsMissing.ENGLISH),

	ALLOW_MOB_TO_SPAWN_UNDER_SPAWN_DEFINED(AllowMobsToSpawnUnderSpawn_Defined.ENGLISH);

	private IMinecraftMessage source;

	private EnglishSpawnMessages(IMinecraftMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (EnglishSpawnMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMinecraftMessage getSource() {
		return source;
	}
}
