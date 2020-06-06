package fr.pederobien.minecraftgameplateform.impl.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bukkit.World;

import fr.pederobien.minecraftgameplateform.exceptions.configurations.BorderConfigurationAlreadyRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.BorderConfigurationNotRegisteredException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;
import fr.pederobien.minecraftmanagers.WorldManager;

public abstract class AbstractGameBorderConfiguration extends AbstractGameConfiguration implements IGameBorderConfiguration {
	private Map<World, IBorderConfiguration> configurations;
	private List<IBorderConfiguration> list;

	protected AbstractGameBorderConfiguration(String name) {
		super(name);
		configurations = new HashMap<World, IBorderConfiguration>();
		list = new ArrayList<IBorderConfiguration>();
	}

	@Override
	public List<IBorderConfiguration> getBorders() {
		return sort(list);
	}

	@Override
	public Optional<IBorderConfiguration> getBorder(World world) {
		return Optional.ofNullable(configurations.get(world));
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
		IBorderConfiguration border = configurations.get(configuration.getWorld());
		if (border == null) {
			configurations.put(configuration.getWorld(), configuration);
			list.add(configuration);
		} else if (border.getName().equals(configuration.getName()))
			throw new BorderConfigurationAlreadyRegisteredException(this, configuration);
		else {
			list.remove(border);
			configurations.put(configuration.getWorld(), configuration);
			list.add(configuration);
		}
	}

	@Override
	public void remove(IBorderConfiguration configuration) {
		IBorderConfiguration border = configurations.remove(configuration.getWorld());

		if (border == null)
			throw new BorderConfigurationNotRegisteredException(this, configuration.getName());

		list.remove(border);
	}

	@Override
	public void remove(List<IBorderConfiguration> configurations) {
		for (IBorderConfiguration border : configurations)
			remove(border);
	}

	@Override
	public Optional<IBorderConfiguration> remove(World world) {
		IBorderConfiguration border = configurations.remove(world);
		Optional<IBorderConfiguration> optBorder = Optional.ofNullable(border);

		if (optBorder.isPresent())
			list.remove(border);
		return optBorder;
	}

	@Override
	public List<IBorderConfiguration> clearBorders() {
		configurations.clear();
		List<IBorderConfiguration> removedList = new ArrayList<>(list);
		list.clear();
		return sort(removedList);
	}

	/**
	 * Get a string that looks like : <code>WorldName + " [" + borderName1 + " " + .. + " " + borderNameN + "]"</code>.
	 * 
	 * @param world The world used as key to filter all registered border configurations.
	 * @return A string to display all registered borders for the given world.
	 */
	protected String getWorldBorders(World world) {
		Optional<IBorderConfiguration> optBorder = getBorder(world);
		return WorldManager.getWorldNameNormalised(world) + " : " + (optBorder.isPresent() ? optBorder.get().getName() : "none");
	}

	private List<IBorderConfiguration> sort(List<IBorderConfiguration> list) {
		Collections.sort(list);
		return list;
	}
}
