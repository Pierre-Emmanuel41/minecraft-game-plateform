package fr.pederobien.minecraft.game.platform.exceptions.configurations;

import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

public class TeamNotFoundException extends GameConfigurationException {
	private static final long serialVersionUID = 1L;
	private String teamNotFoundName;

	public TeamNotFoundException(IGameConfiguration gameConfiguration, String teamNotFoundName) {
		super(gameConfiguration);
		this.teamNotFoundName = teamNotFoundName;
	}

	@Override
	protected String getInternalMessage() {
		return "The team \"" + getTeamNotFoundName() + "\" does not exist in configuration " + getGameConfiguration().getName();
	}

	/**
	 * @return The name of the not found team.
	 */
	public String getTeamNotFoundName() {
		return teamNotFoundName;
	}
}
