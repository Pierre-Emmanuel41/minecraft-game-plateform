package fr.pederobien.minecraftgameplateform.worldstructure.spawn.commands;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class SpawnEditionFactory {

	/**
	 * @return An edition to create a new spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> newSpawn() {
		return new NewSpawn();
	}

	/**
	 * @return An edition to rename a spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> renameSpawn() {
		return new RenameSpawn();
	}

	/**
	 * @return An edition to set the dimension of a spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> dimensionSpawn() {
		return new DimensionSpawn();
	}
}
