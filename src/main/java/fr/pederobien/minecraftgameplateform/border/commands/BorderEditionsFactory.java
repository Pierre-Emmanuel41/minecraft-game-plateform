package fr.pederobien.minecraftgameplateform.border.commands;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;

public class BorderEditionsFactory {

	/**
	 * @return An edition to create world border configuration.
	 */
	public static IMapPersistenceEdition<IBorderConfiguration> newBorder() {
		return new NewBorder();
	}
}