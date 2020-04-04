package fr.pederobien.minecraftgameplateform.interfaces.element;

import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableSpawn;

public interface ISpawn extends IUnmodifiableSpawn, IWorldStructure {

	/**
	 * Set the coordinates of the block above which players will spawn. The following coordinates are absolute.
	 * 
	 * @param x The x-Coordinates of the block.
	 * @param y The y-Coordinates of the block.
	 * @param z The z-Coordinates of the block.
	 */
	void setPlayerSpawn(String x, String y, String z);

	/**
	 * Set the coordinates of the block above which players will spawn. The following coordinates are relative to the center.
	 * 
	 * @param x         The x-Coordinates of the block.
	 * @param y         The y-Coordinates of the block.
	 * @param z         The z-Coordinates of the block.
	 * @param blockData the data of the block to load/save.
	 */
	void setRelativePlayerSpawn(String x, String y, String z, String blockData);
}
