package fr.pederobien.minecraftgameplateform.commands.configurations;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum EGameConfigurationLabel implements ILabel {
	AS_CURRENT("ascurrent"), LOAD("load"), SCOREBOARD_REFRESH("scoreboardrefresh");

	private String label;

	private EGameConfigurationLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
