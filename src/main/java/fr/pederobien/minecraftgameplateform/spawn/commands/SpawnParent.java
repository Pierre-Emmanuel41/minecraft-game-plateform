package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.impl.editions.AbstractParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.spawn.messages.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.spawn.persistence.SpawnPersistence;

public class SpawnParent extends AbstractParentPersistenceEdition<ISpawn> {

	public SpawnParent(Plugin plugin) {
		super("spawn", ESpawnMessageCode.SPAWN_PARENT_EXPLANATION, plugin, SpawnPersistence.getInstance());

		addEdition(SpawnEditionFactory.newSpawn().setModifiable(false));
		addEdition(SpawnEditionFactory.centerSpawn());
		addEdition(SpawnEditionFactory.renameSpawn());
		addEdition(SpawnEditionFactory.dimensionSpawn());
		addEdition(SpawnEditionFactory.saveSpawn());
		addEdition(SpawnEditionFactory.listSpawn().setModifiable(false));
		addEdition(SpawnEditionFactory.deleteSpawn().setModifiable(false));
		addEdition(SpawnEditionFactory.extractSpawn());
		addEdition(SpawnEditionFactory.removeSpawn());
		addEdition(SpawnEditionFactory.launchSpawn().setModifiable(false));
		addEdition(SpawnEditionFactory.currentSpawn());
		addEdition(SpawnEditionFactory.worldSpawn());
		addEdition(SpawnEditionFactory.playerSpawn());
		addEdition(SpawnEditionFactory.randomSpawn().setModifiable(false));
		addEdition(SpawnEditionFactory.allowMobsUnderSpawn());
	}
}
