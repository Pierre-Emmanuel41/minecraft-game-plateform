package fr.pederobien.minecraftgameplateform.impl.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.bukkit.World;

import fr.pederobien.minecraftgameplateform.exceptions.configurations.BorderConfigurationAlreadyRegisteredException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGame;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;

public class GameBorderConfiguration extends GameConfiguration implements IGameBorderConfiguration {
	private Map<World, List<IBorderConfiguration>> configurations;
	private List<IBorderConfiguration> list;

	protected GameBorderConfiguration(String name, IGame game) {
		super(name, game);
		configurations = new HashMap<World, List<IBorderConfiguration>>();
	}

	@Override
	public List<IBorderConfiguration> getBorders() {
		return Collections.unmodifiableList(list);
	}

	@Override
	public List<IBorderConfiguration> getBorders(World world) {
		return Collections.unmodifiableList(configurations.get(world));
	}

	@Override
	public Optional<IBorderConfiguration> getBorder(String name) {
		for (IBorderConfiguration configuration : list)
			if (configuration.getName().equals(name))
				return Optional.of(configuration);
		return Optional.empty();
	}

	@Override
	public void add(IBorderConfiguration configuration) {
		List<IBorderConfiguration> listConf = configurations.get(configuration.getWorld());
		if (listConf == null)
			listConf = new ArrayList<IBorderConfiguration>();

		if (listConf.contains(configuration))
			throw new BorderConfigurationAlreadyRegisteredException(this, configuration);

		listConf.add(configuration);
		list.add(configuration);
	}

	@Override
	public void remove(IBorderConfiguration configuration) {
		List<IBorderConfiguration> listConf = configurations.get(configuration.getWorld());
		if (listConf == null)
			return;

		listConf.remove(configuration);
		list.remove(configuration);

		if (listConf.isEmpty())
			configurations.remove(configuration.getWorld());
	}

	@Override
	public void remove(List<IBorderConfiguration> configurations) {
		Iterator<Entry<World, List<IBorderConfiguration>>> iterator = this.configurations.entrySet().iterator();
		List<IBorderConfiguration> copy = new ArrayList<>(configurations);
		while (iterator.hasNext() && copy.size() > 0) {
			Entry<World, List<IBorderConfiguration>> entry = iterator.next();
			for (int i = 0; i < configurations.size(); i++) {
				IBorderConfiguration configuration = configurations.get(i);
				if (entry.getKey().equals(configuration.getWorld()) && entry.getValue().remove(configuration))
					copy.remove(configuration);
			}
		}
		list.removeAll(configurations);
	}

	@Override
	public List<IBorderConfiguration> remove(World world) {
		List<IBorderConfiguration> confs = configurations.remove(world);
		List<IBorderConfiguration> removed = confs == null ? new ArrayList<>() : confs;

		list.removeIf(conf -> conf.getWorld().equals(world));
		return removed;
	}

	@Override
	public List<IBorderConfiguration> clearBorders() {
		configurations.clear();
		List<IBorderConfiguration> removedList = new ArrayList<>(list);
		list.clear();
		return removedList;
	}
}
