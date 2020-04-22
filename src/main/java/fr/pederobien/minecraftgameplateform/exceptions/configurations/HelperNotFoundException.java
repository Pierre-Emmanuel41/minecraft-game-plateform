package fr.pederobien.minecraftgameplateform.exceptions.configurations;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class HelperNotFoundException extends GameConfigurationException {
	private static final long serialVersionUID = 1L;

	protected HelperNotFoundException(IGameConfiguration gameConfiguration) {
		super(gameConfiguration);
	}

	@Override
	protected String getInternalMessage() {
		return "Helper not found for configuration " + getGameConfiguration().getName();
	}
}
