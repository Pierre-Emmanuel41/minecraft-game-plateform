package fr.pederobien.minecraft.game.platform.commands.configurations.teams.add;

import fr.pederobien.minecraft.game.platform.interfaces.element.ILabel;

public enum ETeamAddLabel implements ILabel {
	TEAM("team"), PLAYER("player");

	private String label;

	private ETeamAddLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
