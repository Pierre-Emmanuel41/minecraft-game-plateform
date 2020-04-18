package fr.pederobien.minecraftgameplateform.interfaces.element;

import java.util.List;

import fr.pederobien.minecraftgameplateform.exceptions.WorldNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.WorldStructureDimensionException;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableWorldStructure;

public interface IWorldStructure extends INominable, IUnmodifiableWorldStructure {

	/**
	 * Set the world in which the structure should be launched or extracted.
	 * 
	 * @param worldName The name of the world in which this structure should be launched or extracted.
	 * 
	 * @throws WorldNotFoundException If the given name correspond to any world.
	 */
	void setWorld(String worldName);

	/**
	 * Set the center of this structure. The center correspond to the block with the following characteristics: It is at the bottom of
	 * the structure, with center x-Coordinates and z-Coordinates. Let's take a structure like this:<br>
	 * X variations : [17;52]<br>
	 * Y variations : [42;99]<br>
	 * Z variations : [-48;11]<br>
	 * <br>
	 * The center's coordinates are : {(52-17+1)/2=18, 42, (11-(-48)+1)/2=30}
	 * 
	 * @param x The x-Coordinates of the center.
	 * @param y The y-Coordinates of the center.
	 * @param z The z-Coordinates of the center.
	 */
	void setCenter(String x, String y, String z);

	/**
	 * Set the width of this structure. The new value of the width has to be greater than or equal to 1. If the value is correct, the
	 * list of blocks of this structure is reset.
	 * 
	 * @param width The new width of this structure.
	 * 
	 * @see #getBlocks()
	 * @see #extract()
	 * 
	 * @throws WorldStructureDimensionException If the width is strictly less than 1.
	 */
	void setWidth(int width);

	/**
	 * Set the height of this structure. The new value of the height has to be greater than or equal to 1. If the value is correct,
	 * the list of blocks of this structure is reset.
	 * 
	 * @param height The new height of this structure.
	 * 
	 * @see #getBlocks()
	 * @see #extract()
	 * 
	 * @throws WorldStructureDimensionException If the height is strictly less than 1.
	 */
	void setHeight(int height);

	/**
	 * Set the depth of this structure. The new value of the depth has to be greater than or equal to 1. If the value is correct, the
	 * list of blocks of this structure is reset.
	 * 
	 * @param depth The new depth of this structure.
	 * 
	 * @see #getBlocks()
	 * @see #extract()
	 * 
	 * @throws WorldStructureDimensionException If the depth is strictly less than 1.
	 */
	void setDepth(int depth);

	/**
	 * Set the list of blocks for this structure. This method should be only called when loading from file.
	 * 
	 * @param blocks The list of blocks that compose this world structure.
	 */
	void setBlocks(List<IWorldBlock> blocks);
}
