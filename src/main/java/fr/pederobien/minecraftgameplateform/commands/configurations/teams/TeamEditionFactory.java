package fr.pederobien.minecraftgameplateform.commands.configurations.teams;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class TeamEditionFactory {

	/**
	 * @return An edition to add teams to a configuration or players to a team.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> commonTeamAdd() {
		return new CommonTeamAdd<T>();
	}

	/**
	 * @return An edition to remove teams from a configuration or players from a team.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> commonTeamRemove() {
		return new CommonTeamRemove<T>();
	}
}
