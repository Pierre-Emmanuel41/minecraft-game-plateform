package fr.pederobien.minecraftgameplateform.worldstructure.spawn.commands;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.dictionary.EMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.worldstructure.commands.WorldStructureEditionFactory;
import fr.pederobien.minecraftgameplateform.worldstructure.spawn.persistence.SpawnPersistence;

public class SpawnParent extends AbstractParentPersistenceEdition<ISpawn> {

	public SpawnParent(Plugin plugin) {
		super("spawn", EMessageCode.SPAWN_PARENT_EXPLANATION, plugin, SpawnPersistence.getInstance());

		addEdition(WorldStructureEditionFactory.CommonCenter());
	}
}
