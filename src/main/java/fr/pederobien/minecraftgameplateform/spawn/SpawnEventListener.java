package fr.pederobien.minecraftgameplateform.spawn;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.minecraftgameplateform.impl.element.AbstractEventListener;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftmanagers.PlayerManager;

public class SpawnEventListener extends AbstractEventListener {
	private ISpawn spawn;

	public SpawnEventListener(ISpawn spawn) {
		this.spawn = spawn;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoiner(PlayerJoinEvent event) {
		if (!isActivated())
			return;
		PlayerManager.teleporte(event.getPlayer(), spawn.getPlayerSpawn().getLocation());
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		if (!isActivated())
			return;
		event.setRespawnLocation(spawn.getPlayerSpawn().getLocation());
	}
}
