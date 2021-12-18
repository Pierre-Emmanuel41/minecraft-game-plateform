package fr.pederobien.minecraft.gameplateform.commands.configurations.teams.modify;

import fr.pederobien.minecraft.gameplateform.interfaces.element.ILabel;

public enum ETeamModifyLabel implements ILabel {
	NAME("name"), COLOR("color");

	private String label;

	private ETeamModifyLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
