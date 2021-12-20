package fr.pederobien.minecraft.game.platform.commands.configurations.teams.remove;

import fr.pederobien.minecraft.game.platform.interfaces.element.ILabel;

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
