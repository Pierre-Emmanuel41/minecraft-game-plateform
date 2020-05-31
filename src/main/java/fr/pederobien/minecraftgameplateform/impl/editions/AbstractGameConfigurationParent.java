package fr.pederobien.minecraftgameplateform.impl.editions;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.commands.common.CommonCurrent;
import fr.pederobien.minecraftgameplateform.commands.common.CommonDelete;
import fr.pederobien.minecraftgameplateform.commands.common.CommonList;
import fr.pederobien.minecraftgameplateform.commands.common.CommonNew;
import fr.pederobien.minecraftgameplateform.commands.common.CommonRename;
import fr.pederobien.minecraftgameplateform.commands.common.CommonSave;
import fr.pederobien.minecraftgameplateform.commands.configurations.GameConfigurationEditionFactory;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;

public abstract class AbstractGameConfigurationParent<T extends IGameConfiguration> extends AbstractParentPersistenceEdition<T> {

	public AbstractGameConfigurationParent(String label, IMinecraftMessageCode explanation, Plugin plugin, IMinecraftPersistence<T> persistence) {
		super(label, explanation, plugin, persistence);

		addEdition(getNewEdition());
		addEdition(getRenameEdition());
		addEdition(getSaveEdition());
		addEdition(getListEdition());
		addEdition(getDeleteEdition());
		addEdition(getCurrentEdition());
		addEdition(GameConfigurationEditionFactory.asCurrentEdition());
		addEdition(GameConfigurationEditionFactory.teamEdition());
		addEdition(GameConfigurationEditionFactory.pvpTime());
	}

	// Specific to create, rename, save, delete or display the list of game configuration.

	/**
	 * The returned edition should extends {@link CommonNew} for more security.
	 * 
	 * @return An edition to create a new game configuration.
	 */
	protected abstract IMapPersistenceEdition<T> getNewEdition();

	/**
	 * The returned edition should extends {@link CommonRename} for more security.
	 * 
	 * @return An edition to rename a game configuration.
	 */
	protected abstract IMapPersistenceEdition<T> getRenameEdition();

	/**
	 * The returned edition should extends {@link CommonSave} for more security.
	 * 
	 * @return An edition to save game configuration informations.
	 */
	protected abstract IMapPersistenceEdition<T> getSaveEdition();

	/**
	 * The returned edition should extends {@link CommonList} for more security.
	 * 
	 * @return An edition to display each existing game configuration name.
	 */
	protected abstract IMapPersistenceEdition<T> getListEdition();

	/**
	 * The returned edition should extends {@link CommonDelete} for more security.
	 * 
	 * @return An edition to delete game configuration file.
	 */
	protected abstract IMapPersistenceEdition<T> getDeleteEdition();

	/**
	 * The returned edition should extends {@link CommonCurrent} for more security.
	 * 
	 * @return An edition to display current configuration's characteristics.
	 */
	protected abstract IMapPersistenceEdition<T> getCurrentEdition();
}
