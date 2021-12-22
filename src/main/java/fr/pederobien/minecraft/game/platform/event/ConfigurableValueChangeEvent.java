package fr.pederobien.minecraft.game.platform.event;

import fr.pederobien.minecraft.game.platform.interfaces.IConfigurable;

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
}
