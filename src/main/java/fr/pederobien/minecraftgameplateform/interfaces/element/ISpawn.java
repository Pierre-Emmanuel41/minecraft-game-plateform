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
	 * @param x The x-Coordinates of the block.
	 * @param y The y-Coordinates of the block.
	 * @param z The z-Coordinates of the block.
	 */
	void setRelativePlayerSpawn(String x, String y, String z);

	/**
	 * If mobs are allowed to spawn under the spawn, then set to true, false otherwise.
	 * 
	 * @param isAllowMobsUnderSpawn true to allow mobs to spawn under the spawn, false otherwise.
	 */
	void setAllowMobsUnderSpawn(boolean isAllowMobsUnderSpawn);
}
