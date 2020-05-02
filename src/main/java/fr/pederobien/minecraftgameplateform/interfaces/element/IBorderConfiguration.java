package fr.pederobien.minecraftgameplateform.interfaces.element;

import org.bukkit.World;

import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableBorderConfiguration;

public interface IBorderConfiguration extends INominable, IUnmodifiableBorderConfiguration {

	/**
	 * Set the world in which this configuration is applied.
	 * 
	 * @param world The world in which the world border is applied.
	 */
	void setWorld(World world);

	/**
	 * Set the x coordinate and the z coordinate of the world border center.
	 * 
	 * @param x The x-Coordinate of the center.
	 * @param z The z-Coordinate of the center.
	 */
	void setBorderCenter(String x, String z);

	/**
	 * Set the initial world border diameter. This value is set in the world when starting a game.
	 * 
	 * @param initialDiameter The initial world border diameter.
	 */
	void setInitialBorderDiameter(int initialDiameter);

	/**
	 * Set the final world border diameter. If the border is moved, it is the target diameter.
	 * 
	 * @param finalDiameter The final world border diameter.
	 */
	void setFinalBorderDiameter(int finalDiameter);

	/**
	 * Set the speed (block/s) at which the border moves from its initial diameter to its final diameter. The real world border speed
	 * on minecraft world correspond to the given speed divided by 2.
	 * 
	 * @param borderSpeed The world border speed.
	 */
	void setBorderSpeed(double borderSpeed);
}
