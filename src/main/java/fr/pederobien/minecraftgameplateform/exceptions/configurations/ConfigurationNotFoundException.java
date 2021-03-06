package fr.pederobien.minecraftgameplateform.exceptions.configurations;

import fr.pederobien.minecraftgameplateform.exceptions.MinecraftPlateformException;

public class ConfigurationNotFoundException extends MinecraftPlateformException {
	private static final long serialVersionUID = 1L;
	private String name;

	public ConfigurationNotFoundException(String name) {
		this.name = name;
	}

	@Override
	protected String getInternalMessage() {
		return "The configuration " + getConfigurationName() + " does not exist";
	}

	/**
	 * @return The not found configuration name.
	 */
	public String getConfigurationName() {
		return name;
	}
}
