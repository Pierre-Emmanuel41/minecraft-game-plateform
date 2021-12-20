package fr.pederobien.minecraft.game.platform.exceptions.persistence;

import fr.pederobien.minecraft.game.platform.exceptions.SimpleMessageException;

public class LoaderNotFoundException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;
	private double version;

	public LoaderNotFoundException(double version) {
		super("No loader found for version : " + version);
		this.version = version;
	}

	/**
	 * @return The version that correspond to any loader.
	 */
	public double getVersion() {
		return version;
	}
}
