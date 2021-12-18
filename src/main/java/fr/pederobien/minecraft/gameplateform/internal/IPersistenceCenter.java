package fr.pederobien.minecraft.gameplateform.internal;

import java.util.Map;

import fr.pederobien.minecraft.gameplateform.interfaces.element.INominable;
import fr.pederobien.minecraft.gameplateform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

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
	<T extends IUnmodifiableNominable> void registerOrUpdate(IMinecraftPersistence<T> persistence);

	/**
	 * Save this center.
	 */
	void save();
}
