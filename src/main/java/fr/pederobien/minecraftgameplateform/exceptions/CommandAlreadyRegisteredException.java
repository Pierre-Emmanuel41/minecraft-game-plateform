package fr.pederobien.minecraftgameplateform.exceptions;

public class CommandAlreadyRegisteredException extends MinecraftPlateformException {
	private static final long serialVersionUID = 1L;
	private String name;

	public CommandAlreadyRegisteredException(String name) {
		this.name = name;
	}

	@Override
	protected String getInternalMessage() {
		return "The command " + getName() + " is already registered";
	}

	/**
	 * @return The already registered command name.
	 */
	public String getName() {
		return name;
	}
}
