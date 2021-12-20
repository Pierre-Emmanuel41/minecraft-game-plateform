package fr.pederobien.minecraft.game.platform.commands.common;

import fr.pederobien.minecraft.game.platform.interfaces.element.ILabel;

public enum ECommonLabel implements ILabel {
	NEW("new"), RENAME("rename"), SAVE("save"), DELETE("delete"), LIST("list"), DETAILS("details"), LOAD("load");

	private String label;

	private ECommonLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
