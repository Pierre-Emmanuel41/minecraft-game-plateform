package fr.pederobien.minecraftgameplateform.exceptions;

public class MinecraftPlateformException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MinecraftPlateformException() {
		super();
	}

	public MinecraftPlateformException(String message) {
		super(message);
	}
}
