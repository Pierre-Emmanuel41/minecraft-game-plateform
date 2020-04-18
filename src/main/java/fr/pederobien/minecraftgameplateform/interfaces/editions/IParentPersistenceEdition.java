package fr.pederobien.minecraftgameplateform.interfaces.editions;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.messagecode.IMessageCodeParentEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public interface IParentPersistenceEdition<T extends IUnmodifiableNominable>
		extends IMessageCodeParentEdition<T, IParentPersistenceEdition<T>, IMapPersistenceEdition<T>>, IPersistenceEdition<T> {

	/**
	 * @return The plugin to which this parent persistence is associated to.
	 */
	Plugin getPlugin();
}
