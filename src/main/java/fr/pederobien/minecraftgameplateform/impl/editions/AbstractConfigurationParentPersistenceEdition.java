package fr.pederobien.minecraftgameplateform.impl.editions;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.commands.common.CommonLoad;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.INominable;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;

public abstract class AbstractConfigurationParentPersistenceEdition<T extends INominable> extends AbstractCommonParentPersistenceEdition<T> {

	public AbstractConfigurationParentPersistenceEdition(String label, IMinecraftMessageCode explanation, Plugin plugin, IMinecraftPersistence<T> persistence) {
		super(label, explanation, plugin, persistence);

		addEdition(getLoadEdition().setModifiable(false));
	}

	// Specific to game configuration in order to load them.

	/**
	 * The returned edition should extends {@link CommonLoad} for more security.
	 * 
	 * @return An edition to load a game configuration in order to modify it.
	 */
	protected abstract IMapPersistenceEdition<T> getLoadEdition();
}
