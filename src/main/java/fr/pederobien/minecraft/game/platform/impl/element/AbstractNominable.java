package fr.pederobien.minecraft.game.platform.impl.element;

import java.util.Objects;

import fr.pederobien.minecraft.game.platform.interfaces.element.INominable;

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
