package fr.pederobien.minecraft.game.platform.exceptions;

import fr.pederobien.minecraftmanagers.EColor;

public class ColorNotFoundException extends SimpleMessageException {
	private static final long serialVersionUID = 1L;
	private String colorName;

	public ColorNotFoundException(String colorName) {
		super("The color \"" + colorName + "\" does not correspond to a color");
		this.colorName = colorName;
	}

	/**
	 * @return The color's name that correspond to any {@link EColor}.
	 */
	public String getColorName() {
		return colorName;
	}
}
