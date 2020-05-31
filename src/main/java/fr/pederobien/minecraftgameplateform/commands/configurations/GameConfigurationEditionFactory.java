package fr.pederobien.minecraftgameplateform.commands.configurations;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class GameConfigurationEditionFactory {

	/**
	 * @return An edition to defined the game associated to this configuration as the game to run for command startgame.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> asCurrentEdition() {
		return new CommonAscurrent<T>();
	}

	/**
	 * @return An edition to manage teams for a game configuration.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> teamEdition() {
		return new CommonTeam<T>();
	}

	/**
	 * @return An edition to manage borders for a game border configuration.
	 */
	public static <T extends IGameBorderConfiguration> IMapPersistenceEdition<T> bordersEdition() {
		return new CommonBorders<T>();
	}

	/**
	 * @return An edition to set the time after which the pvp is enabled.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> pvpTime() {
		return new CommonPvpTime<T>();
	}
}
