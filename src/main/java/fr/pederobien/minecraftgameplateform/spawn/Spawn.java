package fr.pederobien.minecraftgameplateform.spawn;

import java.util.StringJoiner;

import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

import fr.pederobien.minecraftdevelopmenttoolkit.utils.DisplayHelper;
import fr.pederobien.minecraftgameplateform.impl.element.AbstractWorldStructure;
import fr.pederobien.minecraftgameplateform.impl.element.WorldBlock;
import fr.pederobien.minecraftgameplateform.interfaces.element.IEventListener;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldBlock;
import fr.pederobien.minecraftmanagers.WorldManager;

public class Spawn extends AbstractWorldStructure implements ISpawn {
	private static final Block DEFAULT_PLAYER_SPAWN = WorldManager.getFromOverworldHighestBlockYAt(0, 0).getRelative(0, 1, 0);

	private IWorldBlock playerSpawn;
	private IEventListener spawnEventListener;
	private Boolean isAllowMobsUnderSpawn;

	public Spawn(String name) {
		super(name);
		spawnEventListener = new SpawnEventListener(this);
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
	public boolean isAllowMobsUnderSpawn() {
		return isAllowMobsUnderSpawn == null ? true : isAllowMobsUnderSpawn;
	}

	@Override
	public IEventListener getListener() {
		return spawnEventListener;
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
	public void setAllowMobsUnderSpawn(boolean isAllowMobsUnderSpawn) {
		this.isAllowMobsUnderSpawn = isAllowMobsUnderSpawn;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add("Name : " + getName());
		joiner.add("World : " + display(world, getWorld().getName()));
		joiner.add("Center : " + display(center, DisplayHelper.toString(getCenter())));
		joiner.add("Width : " + display(width, getWidth() + " blocks"));
		joiner.add("Height : " + display(height, getHeight() + " blocks"));
		joiner.add("Depth : " + display(depth, getDepth() + " blocks"));
		joiner.add("Player's spawn : " + display(playerSpawn, DisplayHelper.toString(getPlayerSpawn())));
		joiner.add("Allow mobs under spawn : " + display(isAllowMobsUnderSpawn, "" + isAllowMobsUnderSpawn()));
		return joiner.toString();
	}

	private String display(Object object, String display) {
		return display.concat(object == null ? " (default value)" : "");
	}
}
