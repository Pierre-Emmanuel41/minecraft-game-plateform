package fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;

public interface IUnmodifiableBorderConfiguration extends IUnmodifiableNominable {

	/**
	 * @return The plugin to which this border configuration is associated.
	 */
	Plugin getPlugin();

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
}
