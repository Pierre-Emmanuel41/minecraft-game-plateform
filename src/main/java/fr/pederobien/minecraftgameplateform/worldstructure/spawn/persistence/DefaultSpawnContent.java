package fr.pederobien.minecraftgameplateform.worldstructure.spawn.persistence;

import fr.pederobien.minecraftgameplateform.impl.element.persistence.AbstractDefaultContent;

public class DefaultSpawnContent extends AbstractDefaultContent {

	protected DefaultSpawnContent() {
		super("DefaultSpawn");
	}

	@Override
	public String getDefaultContent() {
		return "";
	}
}
