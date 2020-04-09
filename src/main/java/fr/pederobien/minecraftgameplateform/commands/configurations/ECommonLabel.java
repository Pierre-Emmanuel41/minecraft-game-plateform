package fr.pederobien.minecraftgameplateform.commands.configurations;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum ECommonLabel implements ILabel {
	NEW("new"), RENAME("rename"), SAVE("save"), DELETE("delete"), LIST("list");

	private String label;

	private ECommonLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
