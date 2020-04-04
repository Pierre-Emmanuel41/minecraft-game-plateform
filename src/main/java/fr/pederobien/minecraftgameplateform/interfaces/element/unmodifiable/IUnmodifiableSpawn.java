package fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable;

import org.bukkit.block.Block;

import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldBlock;

public interface IUnmodifiableSpawn extends IUnmodifiableWorldStructure {

	/**
	 * Get the block from Minecraft world above which players will spawn.
	 * 
	 * @return The block above which players will spawn. The coordinates of this block are absolute.
	 */
	Block getPlayerSpawn();

	/**
	 * Get a virtual block above which players will spawn. This block correspond to {@link #getPlayerSpawn()} but the coordinates are
	 * relative.
	 * 
	 * @return A virtual block above which players will spawn.
	 */
	IWorldBlock getRelativePlayerSpawn();
}
