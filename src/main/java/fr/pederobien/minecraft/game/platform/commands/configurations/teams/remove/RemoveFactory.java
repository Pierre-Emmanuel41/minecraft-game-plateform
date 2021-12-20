package fr.pederobien.minecraft.game.platform.commands.configurations.teams.remove;

import fr.pederobien.minecraft.game.platform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

public class RemoveFactory {

	/**
	 * @return An edition to remove teams from a configuration.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> removeTeam() {
		return new RemoveTeam<T>();
	}

	/**
	 * @return An edition to remove players from a team.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> removePlayer() {
		return new RemovePlayer<T>();
	}
}
