package fr.pederobien.minecraft.game.platform.impl;

import fr.pederobien.minecraft.game.platform.event.ConfigurableValueChangeEvent;
import fr.pederobien.minecraft.game.platform.interfaces.IConfigurable;
import fr.pederobien.utils.event.EventManager;

public class Configurable<T> implements IConfigurable<T> {
	private String name;
	private T value;

	/**
	 * Creates a configurable value.
	 * 
	 * @param name  The name of the associated game configuration.
	 * @param value The value of this configurable parameter.
	 */
	public Configurable(String name, T value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public T get() {
		return value;
	}

	@Override
	public void set(T value) {
		if (this.value != null && this.value == value)
			return;

		T oldValue = this.value;
		this.value = value;
		EventManager.callEvent(new ConfigurableValueChangeEvent(this, oldValue));
	}
}
