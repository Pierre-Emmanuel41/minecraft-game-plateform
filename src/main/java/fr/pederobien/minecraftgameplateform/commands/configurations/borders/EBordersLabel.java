package fr.pederobien.minecraftgameplateform.commands.configurations.borders;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum EBordersLabel implements ILabel {
	ADD("add"), REMOVE("remove"), LIST("list"), DETAILS("details");

	private String label;

	private EBordersLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
