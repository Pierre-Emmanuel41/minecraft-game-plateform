package fr.pederobien.minecraftgameplateform.border.commands;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum EBorderLabel implements ILabel {
	WORLD("world"), CENTER("center"), INITIAL_DIAMETER("initialDiameter");

	private String label;

	private EBorderLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
