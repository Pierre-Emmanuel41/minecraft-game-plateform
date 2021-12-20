package fr.pederobien.minecraft.game.platform.exceptions.configurations;

import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;

public class TeamsAreTheSameException extends GameConfigurationException {
	private static final long serialVersionUID = 1L;
	private ITeam initialTeam, targetTeam;

	public TeamsAreTheSameException(IGameConfiguration gameConfiguration, ITeam initialTeam, ITeam targetTeam) {
		super(gameConfiguration);
		this.initialTeam = initialTeam;
		this.targetTeam = targetTeam;
	}

	@Override
	protected String getInternalMessage() {
		return "The initial team (" + getInitialTeam().getName() + ") is the target team (" + getTargetTeam().getName() + ")";
	}

	/**
	 * @return The initial team of a player when trying to move him from one team to another one.
	 */
	public ITeam getInitialTeam() {
		return initialTeam;
	}

	/**
	 * @return The target team of a player when trying to move him from one team to another one.
	 */
	public ITeam getTargetTeam() {
		return targetTeam;
	}
}
