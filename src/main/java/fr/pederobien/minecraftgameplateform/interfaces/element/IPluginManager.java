package fr.pederobien.minecraftgameplateform.interfaces.element;

import java.util.Optional;
import java.util.stream.Stream;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public interface IPluginManager {

	/**
	 * Register the given plugin.
	 * 
	 * @param plugin The plugin to register.
	 */
	void register(Plugin plugin);

	/**
	 * Unregister the given plugin.
	 * 
	 * @param plugin The plugin to unregister.
	 */
	void unRegister(Plugin plugin);

	/**
	 * To know if the given is registered in this plugin manager.
	 * 
	 * @param plugin The plugin to check.
	 * 
	 * @return True if the specified plugin is registered, false otherwise.
	 */
	boolean isRegistered(Plugin plugin);

	/**
	 * To know if the plugin associated to the given name is registered in this plugin manager.
	 * 
	 * @param pluginName The plugin's name to check.
	 * @return True if the plugin is registered, false otherwise.
	 */
	boolean isRegistered(String pluginName);

	/**
	 * Get the plugin associated to the given <code>pluginName</code> if it exists.
	 * 
	 * @param pluginName The plugin's name to get the associated plugin.
	 * 
	 * @return An optional that contains the plugin, an empty optional if any plugin with the specified name is registered.
	 */
	Optional<Plugin> getPlugin(String pluginName);

	/**
	 * Get the plugin associated to the given <code>pluginName</code> if it exists as {@link JavaPlugin}.
	 * 
	 * @param pluginName The plugin's name to get the associated plugin.
	 * 
	 * @return An optional that contains the plugin as java plugin , an empty optional if any plugin with the specified name is
	 *         registered.
	 */
	Optional<JavaPlugin> getJavaPlugin(String pluginName);

	/**
	 * @return A stream that contains all registered plugins exception the minecraft-game-plateform.
	 */
	Stream<Plugin> getPlugins();
}
