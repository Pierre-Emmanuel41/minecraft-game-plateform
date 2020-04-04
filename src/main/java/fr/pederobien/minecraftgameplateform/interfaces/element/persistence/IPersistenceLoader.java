package fr.pederobien.minecraftgameplateform.interfaces.element.persistence;

import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public interface IPersistenceLoader<T extends IUnmodifiableNominable> {

	/**
	 * @return The version of this loader.
	 */
	Double getVersion();

	/**
	 * @return The object that the loader has loaded.
	 */
	T get();
}
