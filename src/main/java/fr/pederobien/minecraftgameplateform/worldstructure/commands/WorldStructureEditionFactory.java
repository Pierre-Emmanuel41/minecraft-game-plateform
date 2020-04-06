package fr.pederobien.minecraftgameplateform.worldstructure.commands;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;

public class WorldStructureEditionFactory {

	public static <T extends IWorldStructure> IMapPersistenceEdition<T> CommonCenter() {
		return new CommonCenter<T>();
	}
}
