package fr.pederobien.minecraftgameplateform.impl.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import fr.pederobien.minecraftgameplateform.exceptions.WorldNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.WorldStructureDimensionException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldBlock;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;
import fr.pederobien.minecraftgameplateform.utils.DisplayHelper;
import fr.pederobien.minecraftmanagers.WorldManager;

public class AbstractWorldStructure extends AbstractNominable implements IWorldStructure {
	protected static final World DEFAULT_WORLD = WorldManager.SURFACE_WORLD;
	protected static final Block DEFAULT_CENTER = WorldManager.getHighestBlockYAt(DEFAULT_WORLD, 0, 0);
	protected static final Integer DEFAULT_WIDTH = 1, DEFAULT_HEIGHT = 1, DEFAULT_DEPTH = 1;

	protected World world;
	protected Block center;
	protected List<IWorldBlock> blocks, before;
	protected Integer width, height, depth;

	protected AbstractWorldStructure(String name) {
		super(name);

		blocks = new ArrayList<IWorldBlock>();
		before = new ArrayList<IWorldBlock>();
	}

	@Override
	public World getWorld() {
		return world == null ? DEFAULT_WORLD : world;
	}

	@Override
	public Block getCenter() {
		return center == null ? DEFAULT_CENTER : center;
	}

	@Override
	public int getWidth() {
		return width == null ? DEFAULT_WIDTH : width;
	}

	@Override
	public int getHeight() {
		return height == null ? DEFAULT_HEIGHT : height;
	}

	@Override
	public int getDepth() {
		return depth == null ? DEFAULT_DEPTH : depth;
	}

	@Override
	public void extract() {
		blocks.clear();

		int maxWidth = getWidth() / 2, minWidth = -getWidth() / 2, maxDepth = getDepth() / 2, minDepth = -getDepth() / 2;
		for (int y = 0; y < getHeight(); y++)
			for (int x = minWidth; x <= maxWidth; x++)
				for (int z = minDepth; z <= maxDepth; z++)
					blocks.add(new WorldBlock(x, y, z, getBlockFromCenter(x, y, z).getBlockData()));
	}

	@Override
	public void launch() {
		before.clear();
		for (IWorldBlock block : blocks) {
			before.add(new WorldBlock(block.getX(), block.getY(), block.getZ(), getBlockFromCenter(block.getX(), block.getY(), block.getZ()).getBlockData()));
			updateWorldBlock(block);
		}
	}

	@Override
	public void remove() {
		if (before.isEmpty())
			for (IWorldBlock block : blocks)
				before.add(new WorldBlock(block.getX(), block.getX(), block.getX(), Material.AIR.createBlockData()));
		before.forEach(block -> updateWorldBlock(block));
	}

	@Override
	public List<IWorldBlock> getBlocks() {
		return Collections.unmodifiableList(blocks);
	}

	@Override
	public void setWorld(String worldName) {
		this.world = WorldManager.getWorld(worldName);
		if (world == null)
			throw new WorldNotFoundException(worldName);
		setCenter(getCenter().getX(), getCenter().getX(), getCenter().getX());
	}

	@Override
	public void setCenter(String x, String y, String z) {
		setCenter(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(z));
	}

	@Override
	public void setWidth(int width) {
		checkSize("width", width);
		this.width = width;
	}

	@Override
	public void setHeight(int height) {
		checkSize("height", width);
		this.height = height;
	}

	@Override
	public void setDepth(int depth) {
		checkSize("depth", width);
		this.depth = depth;
	}

	@Override
	public void setBlocks(List<IWorldBlock> blocks) {
		this.blocks = blocks;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add("Name : " + getName());
		joiner.add("World : " + getWorld().getName());
		joiner.add("Center : " + DisplayHelper.toString(getCenter()));
		joiner.add("Width : " + getWidth() + " blocks");
		joiner.add("Height : " + getWidth() + " blocks");
		joiner.add("Depth : " + getWidth() + " blocks");
		return joiner.toString();
	}

	/**
	 * Gets the block at the given offsets
	 *
	 * @param modX X-coordinate offset
	 * @param modY Y-coordinate offset
	 * @param modZ Z-coordinate offset
	 * 
	 * @return Block at the given offsets
	 */
	protected Block getBlockFromCenter(int x, int y, int z) {
		return getCenter().getRelative(x, y, z);
	}

	/**
	 * Gets the block at the given offsets represented by the given block.
	 *
	 * @param block The world that contains the offsets.
	 * 
	 * @see #getBlockFromCenter(int, int, int)
	 * 
	 * @return Block at the given offsets
	 */
	protected Block getBlockFromCenter(IWorldBlock block) {
		return getBlockFromCenter(block.getX(), block.getY(), block.getZ());
	}

	private void updateWorldBlock(IWorldBlock block) {
		Block relativeBlock = getBlockFromCenter(block);
		relativeBlock.setType(block.getBlockData().getMaterial());
		relativeBlock.setBlockData(block.getBlockData());
	}

	private void checkSize(String dimension, int size) {
		if (size < 1)
			throw new WorldStructureDimensionException(dimension, size);
		blocks.clear();
	}

	private void setCenter(int x, int y, int z) {
		center = WorldManager.getBlockAt(getWorld(), x, y, z);
	}
}
