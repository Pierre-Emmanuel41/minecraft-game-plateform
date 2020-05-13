package fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable;

import java.util.List;

import org.bukkit.World;
import org.bukkit.block.Block;

import fr.pederobien.minecraftgameplateform.interfaces.element.IEventListener;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldBlock;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface IUnmodifiableWorldStructure extends IUnmodifiableNominable {

	/**
	 * @return The world in which this structure should be launched or extracted.
	 */
	World getWorld();

	/**
	 * @return The center associated to this structure.
	 */
	Block getCenter();

	/**
	 * @return The width of this structure. This is x-Coordinates variations.
	 */
	int getWidth();

	/**
	 * @return The height of this structure. This is y-Coordinates variations.
	 */
	int getHeight();

	/**
	 * @return The depth of this structure. This is z-Coordinates variations.
	 */
	int getDepth();

	/**
	 * The center, the width, the height and the depth defines a virtual empty structure. This method get all block from the world
	 * relative to the center coordinates to fill this empty structure. Let's take a structure with following properties : <br>
	 * <br>
	 * Center : X=50, Y=100, Z=150 <br>
	 * Width=20, Height=30, Depth=40<br>
	 * <br>
	 * This method extract block using the following way :<br>
	 * X : from (50 - width/2) to (50 + width/2)<br>
	 * Y : from 100 to (100 + height)<br>
	 * Z : from (150 - depth/2) to (150 + depth/2)<br>
	 */
	void extract();

	/**
	 * Launch the structure on the world. Before launching, this method register the original blocks.
	 * 
	 * @see #remove()
	 */
	void launch();

	/**
	 * Remove the structure from the world. If the structure just has been created, then each block from the structure is replaced by
	 * a block of air. If the structure has been launched, then each block is replaced by the former block that used to be at the same
	 * coordinates.
	 * 
	 * @see #launch()
	 */
	void remove();

	/**
	 * @return The list of blocks for this structure. If neither the method launch nor the method extract has been called, then the
	 *         list is empty.
	 */
	List<IWorldBlock> getBlocks();

	/**
	 * @return The listener that interact with minecraft events.
	 */
	IEventListener getListener();

	/**
	 * @return True if this structure is removed from the world, false otherwise.
	 */
	boolean isRemoved();
}
