package fr.pederobien.minecraft.game.platform.commands.configurations.teams.modify;

import fr.pederobien.minecraft.game.platform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

public class ModifyFactory {

	/**
	 * @return An edition to rename teams.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> modifyName() {
		return new ModifyName<T>();
	}

	/**
	 * @return An edition to modify team's color.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> modifyColor() {
		return new ModifyColor<T>();
	}
}
