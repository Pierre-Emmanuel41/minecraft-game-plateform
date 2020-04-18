package fr.pederobien.minecraftgameplateform.impl.element;

import org.bukkit.block.data.BlockData;

import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldBlock;
import fr.pederobien.minecraftmanagers.BukkitManager;

public class WorldBlock implements IWorldBlock {
	private int x, y, z;
	private BlockData blockData;

	public WorldBlock(int x, int y, int z, BlockData blockData) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.blockData = blockData;
	}

	public WorldBlock(String x, String y, String z, String blockData) {
		this(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z), blockData == null ? null : BukkitManager.createBlockData(blockData));
	}

	@Override
	public BlockData getBlockData() {
		return blockData;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getZ() {
		return z;
	}
}
