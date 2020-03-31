package fr.pederobien.minecraftgameplateform.utils;

import fr.pederobien.minecraftgameplateform.impl.element.GameConfigurationContext;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfigurationContext;

public class Plateform {
	private static IGameConfigurationContext context = new GameConfigurationContext();

	/**
	 * @return A context for game. This context is used to start, pause, relaunch and stop the game managed by the current
	 *         configuration of this context.
	 */
	public static IGameConfigurationContext getGameConfigurationContext() {
		return context;
	}
}
