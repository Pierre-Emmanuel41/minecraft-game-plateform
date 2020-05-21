package fr.pederobien.minecraftgameplateform.commands.configurations;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfigurationContext;

public class GameConfigurationEditionFactory {

	/**
	 * An edition to defined the game associated to this configuration as the game to run for command startgame.
	 * 
	 * @param gameContext The game context. This context is used by command startgame to know which game should be ran.
	 * @return A edition.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> asCurrentEdition(IGameConfigurationContext gameContext) {
		return new CommonAscurrent<T>(gameContext);
	}

	/**
	 * @return An edition to manage teams for a game configuration.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> teamEdition() {
		return new CommonTeam<T>();
	}

	/**
	 * @return An edition to set the refresh frequency of the player's scoreboard.
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> scoreboardRefreshEdition() {
		return new CommonScoreboardRefresh<T>();
	}

	/**
	 * @return An edition to manage borders for a game border configuration.
	 */
	public static <T extends IGameBorderConfiguration> IMapPersistenceEdition<T> bordersEdition() {
		return new CommonBorders<T>();
	}
}
