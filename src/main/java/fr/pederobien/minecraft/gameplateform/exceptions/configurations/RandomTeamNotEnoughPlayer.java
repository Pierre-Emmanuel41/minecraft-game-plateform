package fr.pederobien.minecraft.gameplateform.exceptions.configurations;

import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;

public class RandomTeamNotEnoughPlayer extends GameConfigurationException {
	private static final long serialVersionUID = 1L;
	private int playersCount;

	public RandomTeamNotEnoughPlayer(IGameConfiguration gameConfiguration, int playersCount) {
		super(gameConfiguration);
		this.playersCount = playersCount;
	}

	@Override
	protected String getInternalMessage() {
		return "There is not enough players (" + getPlayersCount() + ")";
	}

	/**
	 * @return The number of players currently logged into the server.
	 */
	public int getPlayersCount() {
		return playersCount;
	}
}
