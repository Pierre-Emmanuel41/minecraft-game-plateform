package fr.pederobien.minecraftgameplateform.impl.editions;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.commands.common.CommonDetails;
import fr.pederobien.minecraftgameplateform.commands.common.CommonDelete;
import fr.pederobien.minecraftgameplateform.commands.common.CommonList;
import fr.pederobien.minecraftgameplateform.commands.common.CommonNew;
import fr.pederobien.minecraftgameplateform.commands.common.CommonRename;
import fr.pederobien.minecraftgameplateform.commands.common.CommonSave;
import fr.pederobien.minecraftgameplateform.commands.worldstructure.CommonCenter;
import fr.pederobien.minecraftgameplateform.commands.worldstructure.CommonDimension;
import fr.pederobien.minecraftgameplateform.commands.worldstructure.CommonExtract;
import fr.pederobien.minecraftgameplateform.commands.worldstructure.CommonLaunch;
import fr.pederobien.minecraftgameplateform.commands.worldstructure.CommonWorld;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;

public abstract class AbstractWorldStructureParent<T extends IWorldStructure> extends AbstractParentPersistenceEdition<T> {

	public AbstractWorldStructureParent(String label, IMinecraftMessageCode explanation, Plugin plugin, IMinecraftPersistence<T> persistence) {
		super(label, explanation, plugin, persistence);

		addEdition(getNewEdition());
		addEdition(getRenameEdition());
		addEdition(getSaveEdition());
		addEdition(getListEdition());
		addEdition(getDeleteEdition());
		addEdition(getCurrentEdition());

		addEdition(getWorldEdition());
		addEdition(getCenterEdition());
		addEdition(getDimensionEdition());
		addEdition(getExtractEdition());
		addEdition(getLaunchEdition());
		addEdition(getRemoveEdition());
	}

	// Specific to create, rename, save, delete or display the list of world structure.

	/**
	 * The returned edition should extends {@link CommonNew} for more security.
	 * 
	 * @return An edition to create a new world structure.
	 */
	protected abstract IMapPersistenceEdition<T> getNewEdition();

	/**
	 * The returned edition should extends {@link CommonRename} for more security.
	 * 
	 * @return An edition to rename a world structure.
	 */
	protected abstract IMapPersistenceEdition<T> getRenameEdition();

	/**
	 * The returned edition should extends {@link CommonSave} for more security.
	 * 
	 * @return An edition to save world structure informations.
	 */
	protected abstract IMapPersistenceEdition<T> getSaveEdition();

	/**
	 * The returned edition should extends {@link CommonList} for more security.
	 * 
	 * @return An edition to display each existing world structure name.
	 */
	protected abstract IMapPersistenceEdition<T> getListEdition();

	/**
	 * The returned edition should extends {@link CommonDelete} for more security.
	 * 
	 * @return An edition to delete world structure file.
	 */
	protected abstract IMapPersistenceEdition<T> getDeleteEdition();

	/**
	 * The returned edition should extends {@link CommonDetails} for more security.
	 * 
	 * @return An edition to display current structure's characteristics.
	 */
	protected abstract IMapPersistenceEdition<T> getCurrentEdition();

	// Specific to world structure management

	/**
	 * The returned edition should extends {@link CommonWorld} for more security.
	 * 
	 * @return An edition to define the structure's world.
	 */
	protected abstract IMapPersistenceEdition<T> getWorldEdition();

	/**
	 * The returned edition should extends {@link CommonCenter} for more security.
	 * 
	 * @return An edition to define the structure center.
	 */
	protected abstract IMapPersistenceEdition<T> getCenterEdition();

	/**
	 * The returned edition should extends {@link CommonDimension} for more security.
	 * 
	 * @return An edition to set the structure's dimension.
	 */
	protected abstract IMapPersistenceEdition<T> getDimensionEdition();

	/**
	 * The returned edition should extends {@link CommonExtract} for more security.
	 * 
	 * @return An edition to extract blocks associated to the structure dimensions.
	 */
	protected abstract IMapPersistenceEdition<T> getExtractEdition();

	/**
	 * The return edition should extends {@link CommonLaunch} for more security.
	 * 
	 * @return An edition to launch a structure in the world.
	 */
	protected abstract IMapPersistenceEdition<T> getLaunchEdition();

	/**
	 * @return An edition to remove a structure from its world.
	 */
	protected abstract IMapPersistenceEdition<T> getRemoveEdition();
}
