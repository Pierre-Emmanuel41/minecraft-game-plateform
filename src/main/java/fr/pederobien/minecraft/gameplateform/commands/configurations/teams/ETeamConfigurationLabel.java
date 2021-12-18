package fr.pederobien.minecraft.gameplateform.commands.configurations.teams;

import fr.pederobien.minecraft.gameplateform.interfaces.element.ILabel;

public enum ETeamConfigurationLabel implements ILabel {
	ADD("add"), REMOVE("remove"), MODIFY("modify"), LIST("list"), MOVE("move"), RANDOM("random");

	private String label;

	private ETeamConfigurationLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
