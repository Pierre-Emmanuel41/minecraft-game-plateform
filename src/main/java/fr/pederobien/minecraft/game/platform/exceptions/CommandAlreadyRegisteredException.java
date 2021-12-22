package fr.pederobien.minecraft.game.platform.exceptions;

public class CommandAlreadyRegisteredException extends PlatformException {
	private static final long serialVersionUID = 1L;
	private String name;

	public CommandAlreadyRegisteredException(String name) {
		super(String.format("The command %s is already registered", name));
		this.name = name;
	}

	/**
	 * @return The already registered command name.
	 */
	public String getName() {
		return name;
	}
}
