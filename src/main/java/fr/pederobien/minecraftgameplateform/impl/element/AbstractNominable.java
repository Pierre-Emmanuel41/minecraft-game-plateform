package fr.pederobien.minecraftgameplateform.impl.element;

import java.util.Objects;

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
		Objects.requireNonNull(name, "The name is null");
		this.name = name;
	}
}
