package fr.pederobien.minecraft.game.platform.interfaces.editions;

import fr.pederobien.minecraft.game.platform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface IPersistenceEdition<T extends IUnmodifiableNominable> {

	/**
	 * @return The persistence used to save/load objects associated to the type <code>T</code>.
	 */
	IMinecraftPersistence<T> getPersistence();
}
