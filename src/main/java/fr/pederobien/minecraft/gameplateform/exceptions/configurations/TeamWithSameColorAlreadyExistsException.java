package fr.pederobien.minecraft.gameplateform.exceptions.configurations;

import java.util.StringJoiner;

import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.gameplateform.interfaces.element.ITeam;

public class TeamWithSameColorAlreadyExistsException extends TeamAlreadyExistsException {
	private static final long serialVersionUID = 1L;

	public TeamWithSameColorAlreadyExistsException(IGameConfiguration gameConfiguration, ITeam alreadyExistingTeam) {
		super(gameConfiguration, alreadyExistingTeam);
	}

	@Override
	protected String getInternalMessage() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add("The team \"" + getAlreadyExistingTeam().getName() + "\"");
		joiner.add("already has the color \"" + getAlreadyExistingTeam().getColor() + "\"");
		joiner.add("in configuration " + getGameConfiguration().getName());
		return joiner.toString();
	}
}
