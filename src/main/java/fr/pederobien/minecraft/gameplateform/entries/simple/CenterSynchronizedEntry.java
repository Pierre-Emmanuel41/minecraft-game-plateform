package fr.pederobien.minecraft.gameplateform.entries.simple;

import org.bukkit.World;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftmanagers.WorldManager;

public class CenterSynchronizedEntry extends CenterEntry {
	private World currentWorld;

	/**
	 * Create an entry that display the direction to follow in order to reach the world border center in which the player is.
	 * 
	 * @param score The line number of this entry.
	 */
	public CenterSynchronizedEntry(int score) {
		super(score, WorldManager.getFromOverworldHighestBlockYAt(0, 0));
	}

	@Override
	protected String updateCurrentValue(Player player) {
		if (currentWorld == null || !currentWorld.equals(player.getWorld())) {
			currentWorld = player.getWorld();
			setBlock(currentWorld.getWorldBorder().getCenter().getBlock());
		}
		return super.updateCurrentValue(player);
	}
}
