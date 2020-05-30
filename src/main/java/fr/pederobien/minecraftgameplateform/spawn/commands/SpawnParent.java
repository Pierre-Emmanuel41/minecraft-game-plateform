package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.impl.editions.AbstractWorldStructureParent;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.spawn.persistence.SpawnPersistence;

public class SpawnParent extends AbstractWorldStructureParent<ISpawn> {

	public SpawnParent(Plugin plugin) {
		super("spawn", ESpawnMessageCode.SPAWN_PARENT_EXPLANATION, plugin, SpawnPersistence.getInstance());
		addEdition(SpawnEditionFactory.playerSpawn());
		addEdition(SpawnEditionFactory.randomSpawn().setModifiable(false));
		addEdition(SpawnEditionFactory.allowMobsUnderSpawn());
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getNewEdition() {
		return SpawnEditionFactory.newSpawn().setModifiable(false);
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getRenameEdition() {
		return SpawnEditionFactory.renameSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getSaveEdition() {
		return SpawnEditionFactory.saveSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getListEdition() {
		return SpawnEditionFactory.listSpawn().setModifiable(false);
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getDeleteEdition() {
		return SpawnEditionFactory.deleteSpawn().setModifiable(false);
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getCurrentEdition() {
		return SpawnEditionFactory.currentSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getWorldEdition() {
		return SpawnEditionFactory.worldSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getCenterEdition() {
		return SpawnEditionFactory.centerSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getDimensionEdition() {
		return SpawnEditionFactory.dimensionSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getExtractEdition() {
		return SpawnEditionFactory.extractSpawn();
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getLaunchEdition() {
		return SpawnEditionFactory.launchSpawn().setModifiable(false);
	}

	@Override
	protected IMapPersistenceEdition<ISpawn> getRemoveEdition() {
		return SpawnEditionFactory.removeSpawn();
	}
}
