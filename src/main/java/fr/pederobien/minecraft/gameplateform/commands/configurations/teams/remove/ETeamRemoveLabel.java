package fr.pederobien.minecraft.gameplateform.commands.configurations.teams.remove;

import fr.pederobien.minecraft.gameplateform.interfaces.element.ILabel;

public enum ETeamRemoveLabel implements ILabel {
	TEAM("team"), PLAYER("player");

	private String label;

	private ETeamRemoveLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
