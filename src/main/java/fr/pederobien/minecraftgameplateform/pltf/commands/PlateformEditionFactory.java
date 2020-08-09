package fr.pederobien.minecraftgameplateform.pltf.commands;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.pltf.IPlateformConfiguration;

public class PlateformEditionFactory {

	/**
	 * @return An edition to set additional rules during the course of a game.
	 */
	public static IMapPersistenceEdition<IPlateformConfiguration> rules() {
		return new RulesPlateform();
	}
}
