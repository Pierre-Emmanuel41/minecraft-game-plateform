package fr.pederobien.minecraftgameplateform.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.interfaces.element.IPluginManager;

public class PluginManager implements IPluginManager {
	private List<Plugin> plugins = new ArrayList<Plugin>();

	private PluginManager() {
		plugins = new ArrayList<Plugin>();
	}

	public static IPluginManager getInstance() {
		return SingletonHolder.MANAGER;
	}

	private static class SingletonHolder {
		public static final IPluginManager MANAGER = new PluginManager();
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
		return get(pluginName).isPresent();
	}

	@Override
	public Optional<Plugin> get(String pluginName) {
		return plugins.stream().filter(plugin -> plugin.getName().equals(pluginName)).findFirst();
	}

	@Override
	public Stream<Plugin> getPlugins() {
		return plugins.stream().filter(plugin -> !plugin.getName().equals(Plateform.getName()));
	}
}
