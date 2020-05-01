package fr.pederobien.minecraftgameplateform.commands.configurations.teams;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum ETeamConfigurationLabel implements ILabel {
	ADD("add"), REMOVE("remove"), MODIFY("modify");

	private String label;

	private ETeamConfigurationLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
