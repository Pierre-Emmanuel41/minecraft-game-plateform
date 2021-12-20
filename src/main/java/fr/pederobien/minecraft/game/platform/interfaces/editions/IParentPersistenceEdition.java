package fr.pederobien.minecraft.game.platform.interfaces.editions;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.messagecode.IMessageCodeParentEdition;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface IParentPersistenceEdition<T extends IUnmodifiableNominable>
		extends IMessageCodeParentEdition<T, IParentPersistenceEdition<T>, IMapPersistenceEdition<T>>, IPersistenceEdition<T> {

	/**
	 * @return The plugin to which this parent persistence is associated to.
	 */
	Plugin getPlugin();
}
