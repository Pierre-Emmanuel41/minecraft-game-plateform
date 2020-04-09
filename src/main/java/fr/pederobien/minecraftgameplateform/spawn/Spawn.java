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
	private IWorldBlock relativePlayerSpawn;

	public Spawn(String name) {
		super(name);
	}

	@Override
	public Block getPlayerSpawn() {
		return getBlockFromCenter(relativePlayerSpawn);
	}

	@Override
	public IWorldBlock getRelativePlayerSpawn() {
		return relativePlayerSpawn;
	}

	@Override
	public void setPlayerSpawn(String x, String y, String z) {
		int xOffset = Integer.parseInt(x) - getCenter().getX();
		int yOffset = Integer.parseInt(y) - getCenter().getY();
		int zOffset = Integer.parseInt(z) - getCenter().getZ();
		BlockData blockData = WorldManager.getBlockAt(getWorld(), xOffset, yOffset, zOffset).getBlockData();
		relativePlayerSpawn = new WorldBlock(xOffset, yOffset, zOffset, blockData);
	}

	@Override
	public void setRelativePlayerSpawn(String x, String y, String z, String blockData) {
		relativePlayerSpawn = new WorldBlock(x, y, z, blockData);
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
