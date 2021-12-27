package fr.pederobien.minecraft.platform.entries.simple;

import java.util.StringJoiner;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.managers.WorldManager;
import fr.pederobien.minecraft.platform.entries.EEntryCode;
import fr.pederobien.minecraft.scoreboards.impl.CodeEntry;

public class LocationEntry extends CodeEntry {
	private String delimiter;
	private Block center;

	/**
	 * Create an entry that displays the current player location.
	 * 
	 * @param score     The line number of this entry.
	 * @param delimiter The sequence of characters to be displayed between each element added.
	 * @param center    The player's coordinates are displayed relative to the given center.
	 */
	public LocationEntry(int score, String delimiter, Block center) {
		super(score);
		this.delimiter = delimiter;
		this.center = center;
	}

	/**
	 * Create an entry that displays the current player location.
	 * 
	 * @param score     The line number of this entry.
	 * @param delimiter The sequence of characters to be displayed between each element added.
	 */
	public LocationEntry(int score, String delimiter) {
		this(score, delimiter, WorldManager.getFromOverworldHighestBlockYAt(0, 0));
	}

	/**
	 * Create an entry that displays the current player location.
	 * 
	 * @param score  The line number of this entry.
	 * @param center The player's coordinates are displayed relative to the given center.
	 */
	public LocationEntry(int score, Block center) {
		this(score, " ", center);
	}

	/**
	 * Create an entry that displays the current player location.
	 * 
	 * @param score The line number of this entry.
	 */
	public LocationEntry(int score) {
		this(score, " ");
	}

	@Override
	protected String updateCurrentValue(Player player) {
		Location playerLoc = player.getLocation();
		Integer relativeX = playerLoc.getBlockX() - center.getX();
		Integer relativeY = playerLoc.getBlockY();
		Integer relativeZ = playerLoc.getBlockZ() - center.getZ();
		return new StringJoiner(delimiter).add(relativeX.toString()).add(relativeY.toString()).add(relativeZ.toString()).toString();
	}

	@Override
	protected IMinecraftCode getBeforeAsCode(Player player) {
		return EEntryCode.X_Y_Z;
	}

	/**
	 * @return The center used to calculate the relative player position.
	 */
	public Block getCenter() {
		return center;
	}

	/**
	 * Set the center used to calculate the relative player position.
	 * 
	 * @param center The center used to calculate the relative player position.
	 */
	public void setCenter(Block center) {
		this.center = center;
	}
}
