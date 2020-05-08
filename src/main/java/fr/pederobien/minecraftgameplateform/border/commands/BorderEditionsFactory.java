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

	/**
	 * @return An edition to display current border's characteristics.
	 */
	public static IMapPersistenceEdition<IBorderConfiguration> currentBorder() {
		return new CurrentBorder();
	}

	/**
	 * @return An edition to load a world border configuration.
	 */
	public static IMapPersistenceEdition<IBorderConfiguration> loadBorder() {
		return new LoadBorder();
	}

	/**
	 * @return An edition to delete a border's file.
	 */
	public static IMapPersistenceEdition<IBorderConfiguration> deleteBorder() {
		return new DeleteBorder();
	}

	/**
	 * @return An edition to display each existing border's name.
	 */
	public static IMapPersistenceEdition<IBorderConfiguration> listBorder() {
		return new ListBorder();
	}

	/**
	 * @return An edition to rename a border.
	 */
	public static IMapPersistenceEdition<IBorderConfiguration> renameBorder() {
		return new RenameBorder();
	}

	/**
	 * @return An edition to set the world in which the border is applied.
	 */
	public static IMapPersistenceEdition<IBorderConfiguration> worldBorder() {
		return new WorldBorder();
	}
}
