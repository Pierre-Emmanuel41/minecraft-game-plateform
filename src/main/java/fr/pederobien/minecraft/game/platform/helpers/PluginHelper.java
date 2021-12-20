package fr.pederobien.minecraft.game.platform.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraft.game.platform.interfaces.element.IPluginHelper;

public class PluginHelper implements IPluginHelper {
	private List<Plugin> plugins = new ArrayList<Plugin>();

	private PluginHelper() {
		plugins = new ArrayList<Plugin>();
	}

	public static IPluginHelper getInstance() {
		return SingletonHolder.HELPER;
	}

	private static class SingletonHolder {
		public static final IPluginHelper HELPER = new PluginHelper();
	}

	@Override
	public void register(Plugin plugin) {
		if (!plugins.contains(plugin))
			plugins.add(plugin);
	}

	@Override
	public void unRegister(Plugin plugin) {
		plugins.remove(plugin);
	}

	@Override
	public boolean isRegistered(Plugin plugin) {
		return plugins.contains(plugin);
	}

	@Override
	public boolean isRegistered(String pluginName) {
		return getPlugin(pluginName).isPresent();
	}

	@Override
	public Optional<Plugin> getPlugin(String pluginName) {
		return plugins.stream().filter(plugin -> plugin.getName().equals(pluginName)).findFirst();
	}

	@Override
	public Optional<JavaPlugin> getJavaPlugin(String pluginName) {
		Optional<Plugin> optPlugin = getPlugin(pluginName);
		return optPlugin.isPresent() ? Optional.of((JavaPlugin) optPlugin.get()) : Optional.empty();
	}

	@Override
	public Stream<Plugin> getPlugins() {
		return plugins.stream();
	}
}
