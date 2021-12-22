package fr.pederobien.minecraft.game.platform.interfaces;

public interface IConfigurable<T> {

	/**
	 * @return The name of the configuration associated to this configurable parameter.
	 */
	String getName();

	/**
	 * @return The value of this configurable value.
	 */
	T get();

	/**
	 * Set the new value of this configurable value.
	 * 
	 * @param value The new value.
	 */
	void set(T value);
}
