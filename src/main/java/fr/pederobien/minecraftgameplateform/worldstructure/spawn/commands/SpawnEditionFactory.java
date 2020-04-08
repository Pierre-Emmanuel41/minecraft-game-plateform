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

	/**
	 * @return An edition to save a spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> saveSpawn() {
		return new SaveSpawn();
	}

	/**
	 * @return An edition to display each existing spawn's name.
	 */
	public static IMapPersistenceEdition<ISpawn> listSpawn() {
		return new ListSpawn();
	}
}
