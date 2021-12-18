package fr.pederobien.minecraft.gameplateform.commands.configurations;

import fr.pederobien.minecraft.gameplateform.interfaces.element.ILabel;

public enum EGameConfigurationLabel implements ILabel {
	AS_CURRENT("ascurrent"), TEAM("team"), BORDERS("borders"), PVP_TIME("pvpTime");

	private String label;

	private EGameConfigurationLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
