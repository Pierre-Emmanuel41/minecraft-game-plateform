package fr.pederobien.minecraftgameplateform.exceptions;

public class IllegalPathException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;

	public IllegalPathException() {
		super("The path should begin with \"minecraft-game-plateform\" (protected static final Path ROOT in AbstractPersistence)");
	}
}
