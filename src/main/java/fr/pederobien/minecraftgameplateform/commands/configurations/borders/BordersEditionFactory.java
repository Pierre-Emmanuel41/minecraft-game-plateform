package fr.pederobien.minecraftgameplateform.commands.configurations.borders;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;

public class BordersEditionFactory {

	/**
	 * @return An edition to add border configurations to a game configuration.
	 */
	public static <T extends IGameBorderConfiguration> IMapPersistenceEdition<T> addBorders() {
		return new AddBorders<T>();
	}

	/**
	 * @return An edition to remove border configurations from a game configuration.
	 */
	public static <T extends IGameBorderConfiguration> IMapPersistenceEdition<T> removeBorders() {
		return new RemoveBorders<>();
	}
}
