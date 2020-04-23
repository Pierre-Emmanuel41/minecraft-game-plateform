package fr.pederobien.minecraftgameplateform.commands.configurations.teams.add;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum ETeamAddLabel implements ILabel {
	TEAM("team");

	private String label;

	private ETeamAddLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
