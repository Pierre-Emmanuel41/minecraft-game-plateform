package fr.pederobien.minecraft.platform.entries.simple;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.platform.entries.EEntryCode;

public class CenterEntry extends OrientationEntry {

	/**
	 * Create an entry that display the direction to follow in order to reach the center of the world.
	 * 
	 * @param score The line number of this entry.
	 * @param block The block defined as the center of the world.
	 */
	public CenterEntry(int score, Block block) {
		super(score, block);
	}

	@Override
	protected final IMinecraftCode getBeforeAsCode(Player player) {
		return EEntryCode.CENTER;
	}
}
