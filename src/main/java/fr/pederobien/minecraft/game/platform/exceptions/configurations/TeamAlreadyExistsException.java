package fr.pederobien.minecraft.game.platform.exceptions.configurations;

import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;

public abstract class TeamAlreadyExistsException extends GameConfigurationException {
	private static final long serialVersionUID = 1L;
	private ITeam alreadyExistingTeam;

	protected TeamAlreadyExistsException(IGameConfiguration gameConfiguration, ITeam alreadyExistingTeam) {
		super(gameConfiguration);
		this.alreadyExistingTeam = alreadyExistingTeam;
	}

	/**
	 * @return The already existing team for this configuration.
	 */
	public ITeam getAlreadyExistingTeam() {
		return alreadyExistingTeam;
	}
}
