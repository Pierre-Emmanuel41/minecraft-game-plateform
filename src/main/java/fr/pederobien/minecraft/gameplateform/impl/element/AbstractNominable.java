package fr.pederobien.minecraft.gameplateform.impl.element;

import java.util.Objects;

import fr.pederobien.minecraft.gameplateform.interfaces.element.INominable;

public abstract class AbstractNominable implements INominable {
	private String name;

	protected AbstractNominable(String name) {
		this.name = name;
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
