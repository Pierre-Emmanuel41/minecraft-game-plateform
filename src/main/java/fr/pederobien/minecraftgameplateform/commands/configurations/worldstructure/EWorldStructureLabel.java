package fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum EWorldStructureLabel implements ILabel {
	WORLD("world"), CENTER("center"), DIMENSION("dimension"), EXTRACT("extract"), REMOVE("remove"), LAUNCH("launch");

	private String label;

	private EWorldStructureLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
