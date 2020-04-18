package fr.pederobien.minecraftgameplateform.utils;

import fr.pederobien.minecraftdictionary.impl.NotificationCenter;
import fr.pederobien.minecraftdictionary.interfaces.INotificationCenter;
import fr.pederobien.minecraftgameplateform.impl.element.GameConfigurationContext;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;
import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommandHelper;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfigurationContext;

public class Plateform {
	private static IGameConfigurationContext context = GameConfigurationContext.getInstance();
	private static INotificationCenter center = NotificationCenter.getInstance();
	private static ICommandHelper helper = CommandHelper.getInstance();

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

	/**
	 * @return The helper used to register commands. Once a command has been registered, it is impossible to unregister it. However,
	 *         it is possible to not display it by setting {@link ICommand#setAvailable(boolean)} to false.
	 */
	public static ICommandHelper getCommandHelper() {
		return helper;
	}
}
