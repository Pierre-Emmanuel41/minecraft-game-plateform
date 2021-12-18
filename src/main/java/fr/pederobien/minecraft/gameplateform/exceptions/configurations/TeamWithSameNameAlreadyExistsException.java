package fr.pederobien.minecraft.gameplateform.exceptions.configurations;

import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.gameplateform.interfaces.element.ITeam;

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
