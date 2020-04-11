package fr.pederobien.minecraftgameplateform.exceptions.persistence;

import java.nio.file.Path;

import fr.pederobien.minecraftgameplateform.exceptions.SimpleMessageException;

public class IllegalPathException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;

	public IllegalPathException(Path path) {
		super("The path should begin with \"minecraft-game-plateform\" (" + path + ")");
	}
}
