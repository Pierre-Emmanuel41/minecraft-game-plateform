package fr.pederobien.minecraft.platform.interfaces;

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
	 * @return The default value of this configurable value.
	 */
	T getDefault();

	/**
	 * Set the new value of this configurable value.
	 * 
	 * @param value The new value.
	 */
	void set(T value);
}
