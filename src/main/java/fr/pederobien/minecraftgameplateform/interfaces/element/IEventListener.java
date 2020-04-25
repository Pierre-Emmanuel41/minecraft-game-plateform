package fr.pederobien.minecraftgameplateform.interfaces.element;

import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public interface IEventListener extends Listener {

	/**
	 * Register this listener on the server.
	 * 
	 * @param plugin The plugin for which the listener works.
	 */
	void register(Plugin plugin);

	/**
	 * @return True if this listener is registered on the server, false otherwise.
	 */
	boolean isRegistered();

	/**
	 * If activated, the listener will react on minecraft events.
	 * 
	 * @param isActivated True if this listener is activated, false otherwise.
	 */
	void setActivated(boolean isActivated);

	/**
	 * @return True if this listener is activated ans react on minecraft events, false otherwise.
	 */
	boolean isActivated();
}
