package fr.pederobien.minecraftgameplateform.impl.element.persistence;

import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IDefaultContent;

public abstract class AbstractDefaultContent implements IDefaultContent {
	private String name;

	protected AbstractDefaultContent(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
