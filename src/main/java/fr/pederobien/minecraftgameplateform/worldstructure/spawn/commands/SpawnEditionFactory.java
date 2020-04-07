package fr.pederobien.minecraftgameplateform.worldstructure.spawn.commands;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class SpawnEditionFactory {

	/**
	 * @return an edition used to create a new spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> newSpawn() {
		return new NewSpawn();
	}

	/**
	 * @return an edition to set the dimension of the spawn.
	 */
	public static IMapPersistenceEdition<ISpawn> dimensionSpawn() {
		return new DimensionSpawn();
	}
}
