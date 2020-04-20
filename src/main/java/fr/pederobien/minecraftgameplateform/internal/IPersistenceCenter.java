package fr.pederobien.minecraftgameplateform.internal;

import java.util.Map;

import fr.pederobien.minecraftgameplateform.interfaces.element.INominable;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public interface IPersistenceCenter extends INominable {

	/**
	 * Register for the given class name the specified version number.
	 * 
	 * @param className The class that should represent a persistence.
	 * @param version   The version number of this persistence.
	 */
	void register(String className, double version);

	/**
	 * @return All registered persistencies. This map is unmodifiable.
	 */
	Map<String, Double> getPersistencies();

	/**
	 * Add the given persistence to this register. This
	 * 
	 * @param persistence
	 */
	<T extends IUnmodifiableNominable> void registerOrUpdate(IPersistence<T> persistence);

	/**
	 * Save this center.
	 */
	void save();
}
