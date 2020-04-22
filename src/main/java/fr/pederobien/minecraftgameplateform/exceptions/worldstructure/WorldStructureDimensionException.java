package fr.pederobien.minecraftgameplateform.exceptions.worldstructure;

import fr.pederobien.minecraftgameplateform.exceptions.SimpleMessageException;

public class WorldStructureDimensionException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;

	public WorldStructureDimensionException(String dimension, int size) {
		super("The " + dimension + " has to be greater than or equal to 1 (curent:" + size + ")");
	}

}
