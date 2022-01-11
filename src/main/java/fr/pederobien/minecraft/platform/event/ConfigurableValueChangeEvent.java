package fr.pederobien.minecraft.platform.event;

import java.util.StringJoiner;

import fr.pederobien.minecraft.platform.interfaces.IConfigurable;

public class ConfigurableValueChangeEvent extends ProjectGamePlatformEvent {
	private IConfigurable<?> configurable;
	private Object oldValue;

	/**
	 * Creates an event thrown when the value of a configurable object changes.
	 * 
	 * @param configurable The configurable source involved in this event.
	 */
	public ConfigurableValueChangeEvent(IConfigurable<?> configurable, Object oldValue) {
		this.configurable = configurable;
		this.oldValue = oldValue;
	}

	/**
	 * @return The configurable involved in this event.
	 */
	public IConfigurable<?> getConfigurable() {
		return configurable;
	}

	/**
	 * @return The old configurable value.
	 */
	public Object getOldValue() {
		return oldValue;
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(", ", "{", "}");
		joiner.add("parameter=" + getConfigurable().getName());
		joiner.add("oldValue=" + getOldValue());
		joiner.add("newValue=" + getConfigurable().get());
		return String.format("%s_%s", getName(), joiner);
	}
}
