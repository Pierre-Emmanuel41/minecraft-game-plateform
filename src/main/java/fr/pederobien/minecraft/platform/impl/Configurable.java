package fr.pederobien.minecraft.platform.impl;

import fr.pederobien.minecraft.platform.event.ConfigurableValueChangeEvent;
import fr.pederobien.minecraft.platform.interfaces.IConfigurable;
import fr.pederobien.utils.event.EventManager;

public class Configurable<T> implements IConfigurable<T> {
	private String name;
	private T value, defaultValue;

	/**
	 * Creates a configurable value.
	 * 
	 * @param name         The name of this configurable parameter.
	 * @param value        The value of this configurable parameter.
	 * @param defaultValue The default value of this configurable parameter.
	 */
	public Configurable(String name, T value, T defaultValue) {
		this.name = name;
		this.value = value;
		this.defaultValue = defaultValue;
	}

	/**
	 * Creates a configurable value.
	 * 
	 * @param name  The name of this configurable parameter.
	 * @param value The value of this configurable parameter.
	 */
	public Configurable(String name, T value) {
		this(name, value, value);
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
	public T getDefault() {
		return defaultValue;
	}

	@Override
	public void set(T value) {
		if (this.value != null && this.value.equals(value))
			return;

		T oldValue = this.value;
		this.value = value;
		EventManager.callEvent(new ConfigurableValueChangeEvent(this, oldValue));
	}

	@Override
	public String toString() {
		return get().toString();
	}
}
