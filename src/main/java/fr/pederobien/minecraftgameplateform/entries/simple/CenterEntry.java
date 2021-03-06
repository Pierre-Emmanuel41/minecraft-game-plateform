package fr.pederobien.minecraftgameplateform.entries.simple;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.entries.EEntryMessageCode;

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
	protected final IMinecraftMessageCode getBeforeAsCode(Player player) {
		return EEntryMessageCode.CENTER;
	}
}
