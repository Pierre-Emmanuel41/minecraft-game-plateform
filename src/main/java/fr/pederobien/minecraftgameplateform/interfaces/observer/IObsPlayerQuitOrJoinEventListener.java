package fr.pederobien.minecraftgameplateform.interfaces.observer;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public interface IObsPlayerQuitOrJoinEventListener {

	/**
	 * Notify this observer a player has quit the server.
	 * 
	 * @param event The event thrown by the server.
	 */
	void onPlayerQuitEvent(PlayerQuitEvent event);

	/**
	 * Notify this observer a player has join the server.
	 * 
	 * @param event The event thrown by the server.
	 */
	void onPlayerJoinEvent(PlayerJoinEvent event);
}
