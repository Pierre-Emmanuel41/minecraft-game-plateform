package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.worldstructure.CommonExtract;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class ExtractSpawn extends CommonExtract<ISpawn> {

	protected ExtractSpawn() {
		super(ESpawnMessageCode.EXTRACT_SPAWN__EXPLANATION);
	}

	@Override
	protected void onExtracted(CommandSender sender, String name) {
		sendSynchro(sender, ESpawnMessageCode.EXTRACT_SPAWN__SPAWN_EXTRACTED, name);
	}
}
