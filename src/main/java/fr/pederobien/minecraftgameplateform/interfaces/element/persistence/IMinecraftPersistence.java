package fr.pederobien.minecraftgameplateform.interfaces.element.persistence;

import fr.pederobien.persistence.interfaces.IPersistence;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface IMinecraftPersistence<T extends IUnmodifiableNominable> extends IPersistence<T> {

	/**
	 * Method called if the method {@link #forceUpdate()} returns true or if the version has changed.
	 */
	void update();

	/**
	 * @return The file name of the default object associated to this persistence.
	 */
	String getDefault();

	/**
	 * Method called when the file associated to the default object does not exists.
	 */
	void saveDefault();
}
