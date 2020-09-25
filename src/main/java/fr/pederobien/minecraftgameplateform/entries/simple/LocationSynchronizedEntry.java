package fr.pederobien.minecraftgameplateform.entries.simple;

import org.bukkit.World;
import org.bukkit.entity.Player;

public class LocationSynchronizedEntry extends LocationEntry {
	private World currentWorld;

	/**
	 * Create an entry that displays the current player location. The displayed position is synchronized with the world border center
	 * in which the player is located. If the player moves from one world to another one, the center is updated and the displayed
	 * location is relative to the new center.
	 * 
	 * @param score The line number of this entry.
	 */
	public LocationSynchronizedEntry(int score) {
		super(score);
	}

	@Override
	protected String updateCurrentValue(Player player) {
		if (currentWorld == null || !currentWorld.equals(player.getWorld())) {
			currentWorld = player.getWorld();
			setCenter(currentWorld.getWorldBorder().getCenter().getBlock());
		}
		return super.updateCurrentValue(player);
	}
}
