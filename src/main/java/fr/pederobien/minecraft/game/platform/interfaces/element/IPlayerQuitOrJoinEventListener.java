package fr.pederobien.minecraft.game.platform.interfaces.element;

import fr.pederobien.minecraft.game.platform.interfaces.observer.IObsPlayerQuitOrJoinEventListener;

public interface IPlayerQuitOrJoinEventListener extends IEventListener {

	/**
	 * Appends an observer in order to be notified when a player quit or join the server.
	 * 
	 * @param obs The observer to add.
	 */
	void addObserver(IObsPlayerQuitOrJoinEventListener obs);

	/**
	 * Remove an observer for this event listener.
	 * 
	 * @param obs The observer to remove.
	 */
	void removeObserver(IObsPlayerQuitOrJoinEventListener obs);
}
