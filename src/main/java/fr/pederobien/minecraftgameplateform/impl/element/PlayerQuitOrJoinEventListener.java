package fr.pederobien.minecraftgameplateform.impl.element;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.pederobien.minecraftgameplateform.impl.observer.Observable;
import fr.pederobien.minecraftgameplateform.interfaces.element.IPlayerQuitOrJoinEventListener;
import fr.pederobien.minecraftgameplateform.interfaces.observer.IObsPlayerQuitOrJoinEventListener;

public class PlayerQuitOrJoinEventListener extends EventListener implements IPlayerQuitOrJoinEventListener {
	private Observable<IObsPlayerQuitOrJoinEventListener> observable;

	public PlayerQuitOrJoinEventListener() {
		observable = new Observable<IObsPlayerQuitOrJoinEventListener>();
	}

	@Override
	public void addObserver(IObsPlayerQuitOrJoinEventListener obs) {
		observable.addObserver(obs);
	}

	@Override
	public void removeObserver(IObsPlayerQuitOrJoinEventListener obs) {
		observable.removeObserver(obs);
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		observable.notifyObservers(obs -> obs.onPlayerQuitEvent(event));
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		observable.notifyObservers(obs -> obs.onPlayerJoinEvent(event));
	}
}
