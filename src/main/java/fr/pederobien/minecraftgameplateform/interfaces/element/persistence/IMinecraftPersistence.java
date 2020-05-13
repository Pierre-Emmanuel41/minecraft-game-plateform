package fr.pederobien.minecraftgameplateform.interfaces.element.persistence;

import fr.pederobien.persistence.interfaces.IPersistence;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface IMinecraftPersistence<T extends IUnmodifiableNominable> extends IPersistence<T> {

	/**
	 * @return The default content to save when the plugin is enabled.
	 */
	IDefaultContent getDefaultContent();
}
