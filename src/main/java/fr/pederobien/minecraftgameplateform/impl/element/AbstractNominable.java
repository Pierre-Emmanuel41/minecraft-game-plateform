package fr.pederobien.minecraftgameplateform.impl.element;

import fr.pederobien.minecraftgameplateform.interfaces.element.INominable;

public abstract class AbstractNominable implements INominable {
	private String name;

	protected AbstractNominable(String name) {
		setName(name);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
