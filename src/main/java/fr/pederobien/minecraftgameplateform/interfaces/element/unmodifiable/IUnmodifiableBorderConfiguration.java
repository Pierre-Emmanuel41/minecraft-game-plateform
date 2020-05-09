package fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable;

import java.time.LocalTime;

import org.bukkit.World;
import org.bukkit.block.Block;

public interface IUnmodifiableBorderConfiguration extends IUnmodifiableNominable {

	/**
	 * @return The world on which this configuration is applied.
	 */
	World getWorld();

	/**
	 * @return The world border center.
	 */
	Block getBorderCenter();

	/**
	 * @return The initial world border diameter. This diameter is set when starting a game.
	 */
	Integer getInitialBorderDiameter();

	/**
	 * @return The final world border diameter. If this border is moved, it is target diameter.
	 */
	Integer getFinalBorderDiameter();

	/**
	 * @return The speed (block/s) at which the border is moving from its initial diameter to its final diameter. The real world
	 *         border speed on minecraft world correspond to this speed divided by 2.
	 */
	Double getBorderSpeed();

	/**
	 * @return The time at which the border associated to this configuration moves from its initial diameter to its final diameter. If
	 *         this time correspond to 0h 0m 0s then the border moves when a game starts.
	 * 
	 * @see LocalTime#of(int, int, int)
	 */
	LocalTime getStartTime();

	/**
	 * @return The time it take to move the border from its initial diameter to its final diameter.
	 */
	LocalTime getTimeToMove();
}
