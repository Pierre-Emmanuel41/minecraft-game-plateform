package fr.pederobien.minecraftgameplateform.utils;

import fr.pederobien.minecraftgameplateform.dictionary.NotificationCenter;
import fr.pederobien.minecraftgameplateform.impl.element.GameConfigurationContext;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.INotificationCenter;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfigurationContext;

public class Plateform {
	private static IGameConfigurationContext context = new GameConfigurationContext();
	private static INotificationCenter center = NotificationCenter.getInstance();

	public static String getVersion() {
		return "v1.0-SNAPSHOT";
	}

	/**
	 * @return A context for game. This context is used to start, pause, relaunch and stop the game managed by the current
	 *         configuration of this context.
	 */
	public static IGameConfigurationContext getGameConfigurationContext() {
		return context;
	}

	/**
	 * @return The notification center to send message to player(s) that are currently logged into the server.
	 */
	public static INotificationCenter getNotificationCenter() {
		return center;
	}
}
