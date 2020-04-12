package fr.pederobien.minecraftgameplateform.spawn.commands;

import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;

public enum ESpawnLabel implements ILabel {
	PLAYER_SPAWN("playerspawn");

	private String label;

	private ESpawnLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}
}
