package fr.pederobien.minecraftgameplateform.exceptions.configurations;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class BorderConfigurationNotRegisteredException extends GameConfigurationException {
	private static final long serialVersionUID = 1L;
	private String name;

	public BorderConfigurationNotRegisteredException(IGameConfiguration gameConfiguration, String name) {
		super(gameConfiguration);
		this.name = name;
	}

	@Override
	protected String getInternalMessage() {
		return "The configuration " + getConfigurationName() + " is not registered";
	}

	/**
	 * @return The not registered configuration name.
	 */
	public String getConfigurationName() {
		return name;
	}
}
