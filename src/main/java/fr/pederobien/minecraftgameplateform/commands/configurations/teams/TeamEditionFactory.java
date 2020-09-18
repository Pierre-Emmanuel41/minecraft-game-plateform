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

	/**
	 * @return An edition to modify team's characteristics.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> commonTeamModify() {
		return new CommonTeamModify<T>();
	}

	/**
	 * @return An edition to display the teams of a configuration.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> commonTeamList() {
		return new CommonTeamList<T>();
	}

	/**
	 * @return An edition to move a player from its initial team to another team.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> commonTeamMove() {
		return new CommonTeamMove<T>();
	}

	/**
	 * @return An edition to dispatch randomly players in teams.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> commonTeamRandom() {
		return new CommonTeamRandom<T>();
	}
}
