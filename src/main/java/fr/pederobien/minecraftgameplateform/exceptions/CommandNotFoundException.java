package fr.pederobien.minecraftgameplateform.exceptions;

import java.util.StringJoiner;

import org.bukkit.plugin.Plugin;

public class CommandNotFoundException extends MinecraftPlateformException {
	private static final long serialVersionUID = 1L;
	private Plugin plugin;
	private String label;

	public CommandNotFoundException(Plugin plugin, String label) {
		this.plugin = plugin;
		this.label = label;
	}

	/**
	 * @return The plugin to which the exception is associated.
	 */
	public Plugin getPlugin() {
		return plugin;
	}

	/**
	 * @return The label of the not found command.
	 */
	public String getLabel() {
		return label;
	}

	@Override
	protected String getInternalMessage() {
		StringJoiner joiner = new StringJoiner(", ");
		joiner.add("Command not found in file plugin.yml");
		joiner.add("{Plugin=" + getPlugin().getName() + "}");
		joiner.add("{Command=" + getLabel() + "}");
		return joiner.toString();
	}
}
