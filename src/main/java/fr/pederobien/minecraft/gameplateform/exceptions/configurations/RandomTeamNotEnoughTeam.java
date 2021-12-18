package fr.pederobien.minecraft.gameplateform.exceptions.configurations;

import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;

public class RandomTeamNotEnoughTeam extends GameConfigurationException {
	private static final long serialVersionUID = 1L;
	private int teamCount;

	public RandomTeamNotEnoughTeam(IGameConfiguration gameConfiguration, int teamCount) {
		super(gameConfiguration);
		this.teamCount = teamCount;
	}

	@Override
	protected String getInternalMessage() {
		return "there is not enough teams (" + getTeamCount() + ")";
	}

	/**
	 * @return The number of team.
	 */
	public int getTeamCount() {
		return teamCount;
	}
}
