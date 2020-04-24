package fr.pederobien.minecraftgameplateform.commands.configurations.teams.remove;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum ETeamRemoveLabel implements ILabel {
	TEAM("team");

	private String label;

	private ETeamRemoveLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
