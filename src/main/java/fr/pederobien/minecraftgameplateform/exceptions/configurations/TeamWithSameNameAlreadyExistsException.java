package fr.pederobien.minecraftgameplateform.exceptions.configurations;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;

public class TeamWithSameNameAlreadyExistsException extends TeamAlreadyExistsException {
	private static final long serialVersionUID = 1L;

	public TeamWithSameNameAlreadyExistsException(IGameConfiguration gameConfiguration, ITeam alreadyExistingTeam) {
		super(gameConfiguration, alreadyExistingTeam);
	}

	@Override
	protected String getInternalMessage() {
		return "The team \"" + getAlreadyExistingTeam().getName() + "\" already exists in configuration " + getGameConfiguration().getName();
	}
}
