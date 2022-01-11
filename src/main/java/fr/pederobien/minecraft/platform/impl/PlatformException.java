package fr.pederobien.minecraft.platform.impl;

import fr.pederobien.minecraft.platform.GamePlatformPlugin;

public abstract class PlatformException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PlatformException(String message) {
		super(String.format("Platform version : %s%n%s", GamePlatformPlugin.instance().getDescription().getVersion(), message));
	}
}
