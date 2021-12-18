package fr.pederobien.minecraft.gameplateform.exceptions.worldstructure;

import fr.pederobien.minecraft.gameplateform.exceptions.SimpleMessageException;

public class WorldNotFoundException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;
	private String name;

	public WorldNotFoundException(String name) {
		super("The world " + name + " does not exist");
		this.name = name;
	}

	/**
	 * @return The name that correspond to any world.
	 */
	public String getName() {
		return name;
	}
}
