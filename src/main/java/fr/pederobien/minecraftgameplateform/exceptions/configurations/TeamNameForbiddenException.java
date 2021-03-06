package fr.pederobien.minecraftgameplateform.exceptions.configurations;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class TeamNameForbiddenException extends GameConfigurationException {
	private static final long serialVersionUID = 1L;
	private String forbiddenName;

	public TeamNameForbiddenException(IGameConfiguration gameConfiguration, String fobiddenName) {
		super(gameConfiguration);
		this.forbiddenName = fobiddenName;
	}

	@Override
	protected String getInternalMessage() {
		return "The name \"" + getForbiddenName() + "\" is forbidden";
	}

	/**
	 * @return The name that is forbidden.
	 */
	public String getForbiddenName() {
		return forbiddenName;
	}
}
