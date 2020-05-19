package fr.pederobien.minecraftgameplateform.interfaces.element;

import java.util.List;

import org.bukkit.World;

import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableGameBorderConfiguration;

public interface IGameBorderConfiguration extends IUnmodifiableGameBorderConfiguration, IGameConfiguration {

	/**
	 * Append the given border configuration to this game configuration.
	 * 
	 * @param configuration The border configuration to add.
	 */
	void add(IBorderConfiguration configuration);

	/**
	 * Remove the given border configuration from this game configuration.
	 * 
	 * @param configuration The configuration to remove.
	 */
	void remove(IBorderConfiguration configuration);

	/**
	 * Remove each configuration in the given list <code>configurations</code> from this game configuration.
	 * 
	 * @param configurations The list of border configuration to remove.
	 */
	void removeBorderConfigurations(List<IBorderConfiguration> configurations);

	/**
	 * Remove all border configuration registered for the given world.
	 * 
	 * @param world The world used as key to filter all registered border configurations.
	 * 
	 * @return A list that contains all removed border configuration, it could be empty.
	 */
	List<IBorderConfiguration> removeBorderConfigurations(World world);

	/**
	 * Remove each registered border configuration from this game configuration.
	 * 
	 * @return The list of removed border configuration.
	 */
	List<IBorderConfiguration> clearBorderConfigurations();
}
