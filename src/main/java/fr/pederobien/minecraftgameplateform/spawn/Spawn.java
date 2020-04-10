package fr.pederobien.minecraftgameplateform.spawn;

import java.util.StringJoiner;

import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

import fr.pederobien.minecraftdevelopmenttoolkit.managers.WorldManager;
import fr.pederobien.minecraftgameplateform.impl.element.AbstractWorldStructure;
import fr.pederobien.minecraftgameplateform.impl.element.WorldBlock;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldBlock;
import fr.pederobien.minecraftgameplateform.utils.DisplayHelper;

public class Spawn extends AbstractWorldStructure implements ISpawn {
	private static final Block DEFAULT_PLAYER_SPAWN = WorldManager.getFromSurfaceHighestBlockYAt(0, 0).getRelative(0, 1, 0);

	private IWorldBlock playerSpawn;

	public Spawn(String name) {
		super(name);
	}

	@Override
	public Block getPlayerSpawn() {
		return playerSpawn == null ? DEFAULT_PLAYER_SPAWN : getBlockFromCenter(playerSpawn);
	}

	@Override
	public IWorldBlock getRelativePlayerSpawn() {
		return playerSpawn == null ? new WorldBlock(0, 1, 0, null) : playerSpawn;
	}

	@Override
	public void setPlayerSpawn(String x, String y, String z) {
		int xOffset = Integer.parseInt(x) - getCenter().getX();
		int yOffset = Integer.parseInt(y) - getCenter().getY();
		int zOffset = Integer.parseInt(z) - getCenter().getZ();
		BlockData blockData = WorldManager.getBlockAt(getWorld(), xOffset, yOffset, zOffset).getBlockData();
		playerSpawn = new WorldBlock(xOffset, yOffset, zOffset, blockData);
	}

	@Override
	public void setRelativePlayerSpawn(String x, String y, String z) {
		playerSpawn = new WorldBlock(x, y, z, null);
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add("Name : " + getName());
		joiner.add("World : " + getWorld().getName());
		joiner.add("Center : " + DisplayHelper.toString(getCenter()));
		joiner.add("Spawn : " + DisplayHelper.toString(getPlayerSpawn()));
		joiner.add("Width : " + getWidth() + " blocks");
		joiner.add("Height : " + getWidth() + " blocks");
		joiner.add("Depth : " + getWidth() + " blocks");
		return joiner.toString();
	}
}
