package fr.pederobien.minecraft.game.platform.commands.configurations.teams.add;

import fr.pederobien.minecraft.game.platform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

public class AddFactory {

	/**
	 * @return An edition to add teams to a configuration.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> addTeam() {
		return new AddTeam<T>();
	}

	/**
	 * @return An edition to add players to a team.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> addPlayer() {
		return new AddPlayer<>();
	}
}
