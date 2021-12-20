package fr.pederobien.minecraft.game.platform.commands.configurations;

import fr.pederobien.minecraft.game.platform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

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
	 * @return An edition to set the time after which the pvp is enabled.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> pvpTime() {
		return new CommonPvpTime<T>();
	}
}
