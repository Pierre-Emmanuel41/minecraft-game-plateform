package fr.pederobien.minecraftgameplateform.pltf.commands;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum EPlateformLabel implements ILabel {
	RULES("rules");

	private String label;

	private EPlateformLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
