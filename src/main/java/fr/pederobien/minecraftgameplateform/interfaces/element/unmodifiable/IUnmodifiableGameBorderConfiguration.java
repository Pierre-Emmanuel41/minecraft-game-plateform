package fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable;

import java.util.List;
import java.util.Optional;

import org.bukkit.World;

import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;

public interface IUnmodifiableGameBorderConfiguration extends IUnmodifiableGameConfiguration {

	/**
	 * @return The list of all registered border configuration for this game configuration. This list is unmodifiable.
	 */
	List<IBorderConfiguration> getConfigurations();

	/**
	 * Get a list of border configuration registered for the given world. This list is unmodifiable.
	 * 
	 * @param world The world used as key to filter all registered border configurations.
	 * 
	 * @return A list that contains border configurations. This list is unmodifiable and could be empty.
	 */
	List<IBorderConfiguration> getConfigurations(World world);

	/**
	 * Get the configuration associated to the given name.
	 * 
	 * @param name The configuration name.
	 * 
	 * @return An optional that contains the configuration if it is registered, an empty optional otherwise.
	 */
	Optional<IBorderConfiguration> getConfiguration(String name);
}
