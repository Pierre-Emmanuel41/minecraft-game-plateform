package fr.pederobien.minecraftgameplateform.spawn;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import fr.pederobien.minecraftgameplateform.impl.element.AbstractEventListener;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftmanagers.PlayerManager;
import fr.pederobien.minecraftmanagers.WorldManager;

public class SpawnEventListener extends AbstractEventListener {
	private ISpawn spawn;

	public SpawnEventListener(ISpawn spawn) {
		this.spawn = spawn;
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerJoiner(PlayerJoinEvent event) {
		if (!isActivated())
			return;
		PlayerManager.teleporte(event.getPlayer(), spawn.getPlayerSpawn().getLocation());
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		if (!isActivated())
			return;
		event.setRespawnLocation(spawn.getPlayerSpawn().getLocation());
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		if (spawn.isRemoved() || spawn.isAllowMobsUnderSpawn() || !WorldManager.MOBS.contains(event.getEntityType()) || !isLocationUnderSpawn(event.getLocation()))
			return;

		event.setCancelled(true);
	}

	private boolean isLocationUnderSpawn(Location location) {
		Location from = new Location(spawn.getWorld(), -spawn.getWidth() / 2 + spawn.getCenter().getX() - 20, 0, -spawn.getDepth() / 2 + spawn.getCenter().getZ() - 20);
		Location to = new Location(spawn.getWorld(), spawn.getWidth() / 2 + spawn.getCenter().getX() + 20, 0, spawn.getDepth() / 2 + spawn.getCenter().getZ() + 20);
		return WorldManager.isInAABB2D(location, from, to);
	}

}
