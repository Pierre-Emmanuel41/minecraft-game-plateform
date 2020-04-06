package fr.pederobien.minecraftgameplateform.interfaces.editions;

import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public interface IPersistenceEdition<T extends IUnmodifiableNominable> {

	/**
	 * @return The persistence used to save/load objects associated to the type <code>T</code>.
	 */
	IPersistence<T> getPersistence();
}
