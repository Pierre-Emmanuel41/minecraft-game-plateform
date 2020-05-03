package fr.pederobien.minecraftgameplateform.impl.element;

import java.util.StringJoiner;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.helpers.DisplayHelper;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.WorldManager;

public class BorderConfiguration extends AbstractNominable implements IBorderConfiguration {
	private static final World DEFAULT_WORLD = WorldManager.SURFACE_WORLD;
	private static final Integer DEFAULT_INITIAL_DIAMETER = 2000;
	private static final Integer DEFAULT_FINAL_DIAMETER = 30;
	private static final Double DEFAULT_BORDER_SPEED = 1.0;

	private Plugin plugin;
	private World world;
	private Block center;
	private Integer xCenter, zCenter, initialDiameter, finalDiameter;
	private Double borderSpeed;

	public BorderConfiguration(String name) {
		super(name);
	}

	@Override
	public Plugin getPlugin() {
		return plugin;
	}

	@Override
	public World getWorld() {
		return world == null ? DEFAULT_WORLD : world;
	}

	@Override
	public Block getBorderCenter() {
		return center == null ? WorldManager.getHighestBlockYAt(getWorld(), 0, 0) : WorldManager.getHighestBlockYAt(getWorld(), xCenter, zCenter);
	}

	@Override
	public Integer getInitialBorderDiameter() {
		return initialDiameter == null ? DEFAULT_INITIAL_DIAMETER : initialDiameter;
	}

	@Override
	public Integer getFinalBorderDiameter() {
		return finalDiameter == null ? DEFAULT_FINAL_DIAMETER : finalDiameter;
	}

	@Override
	public Double getBorderSpeed() {
		return borderSpeed == null ? DEFAULT_BORDER_SPEED : borderSpeed;
	}

	@Override
	public void setPlugin(String pluginName) {
		this.plugin = Plateform.getPluginManager().getPlugin(pluginName).get();
	}

	@Override
	public void setWorld(String worldName) {
		this.world = WorldManager.getWorld(worldName);
	}

	@Override
	public void setBorderCenter(int x, int z) {
		this.center = WorldManager.getHighestBlockYAt(getWorld(), x, z);
	}

	@Override
	public void setInitialBorderDiameter(int initialDiameter) {
		this.initialDiameter = initialDiameter;
	}

	@Override
	public void setFinalBorderDiameter(int finalDiameter) {
		this.finalDiameter = finalDiameter;
	}

	@Override
	public void setBorderSpeed(double borderSpeed) {
		this.borderSpeed = borderSpeed;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner("\n");
		joiner.add("Name : " + getName());
		joiner.add("World : " + display(world, getWorld().getName()));
		joiner.add("Center : " + display(center, DisplayHelper.toString(getBorderCenter())));
		joiner.add("Initial diameter : " + display(initialDiameter, getInitialBorderDiameter() + " blocks"));
		joiner.add("Final diameter : " + display(finalDiameter, getFinalBorderDiameter() + " blocks"));
		joiner.add("Speed : " + display(borderSpeed, getBorderSpeed() + " block/s"));
		joiner.add("Plugin : " + plugin == null ? "none" : getPlugin().getName());
		return joiner.toString();
	}

	private String display(Object object, String display) {
		return display.concat(object == null ? " (default value)" : "");
	}
}