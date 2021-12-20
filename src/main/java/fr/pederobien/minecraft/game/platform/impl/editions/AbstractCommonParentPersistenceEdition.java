package fr.pederobien.minecraft.game.platform.impl.editions;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraft.game.platform.commands.common.CommonDelete;
import fr.pederobien.minecraft.game.platform.commands.common.CommonDetails;
import fr.pederobien.minecraft.game.platform.commands.common.CommonList;
import fr.pederobien.minecraft.game.platform.commands.common.CommonNew;
import fr.pederobien.minecraft.game.platform.commands.common.CommonRename;
import fr.pederobien.minecraft.game.platform.commands.common.CommonSave;
import fr.pederobien.minecraft.game.platform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraft.game.platform.interfaces.element.INominable;
import fr.pederobien.minecraft.game.platform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public abstract class AbstractCommonParentPersistenceEdition<T extends INominable> extends AbstractParentPersistenceEdition<T> {

	public AbstractCommonParentPersistenceEdition(String label, IMinecraftMessageCode explanation, Plugin plugin, IMinecraftPersistence<T> persistence) {
		super(label, explanation, plugin, persistence);

		addEdition(getNewEdition().setModifiable(false));
		addEdition(getRenameEdition());
		addEdition(getSaveEdition());
		addEdition(getListEdition().setModifiable(false));
		addEdition(getDeleteEdition().setModifiable(false));
		addEdition(getDetailsEdition());
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
	 * The returned edition should extends {@link CommonDetails} for more security.
	 * 
	 * @return An edition to display current configuration's characteristics.
	 */
	protected abstract IMapPersistenceEdition<T> getDetailsEdition();

}
