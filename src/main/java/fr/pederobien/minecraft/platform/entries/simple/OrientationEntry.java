package fr.pederobien.minecraft.platform.entries.simple;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.minecraft.managers.EArrows;
import fr.pederobien.minecraft.managers.WorldManager;
import fr.pederobien.minecraft.scoreboards.impl.CodeEntry;

public class OrientationEntry extends CodeEntry {
	private Block block;

	/**
	 * Create an entry that displays the orientation to follow to reach the given block.
	 * 
	 * @param score The line number of this entry.
	 * @param block The target block.
	 */
	public OrientationEntry(int score, Block block) {
		super(score);
		this.block = block;
	}

	/**
	 * Create an entry that displays the orientation to follow to reach the given block.
	 * 
	 * @param score The line number of this entry.
	 */
	public OrientationEntry(int score) {
		this(score, WorldManager.getFromOverworldHighestBlockYAt(0, 0));
	}

	@Override
	protected String updateCurrentValue(Player player) {
		return EArrows.getArrow(WorldManager.getYaw(player, getBlock().getLocation())).getUnicode();
	}

	/**
	 * @return The block to reach.
	 */
	public Block getBlock() {
		return block;
	}

	/**
	 * Set The block to reach.
	 * 
	 * @param block The block to reach.
	 */
	public void setBlock(Block block) {
		this.block = block;
	}
}
