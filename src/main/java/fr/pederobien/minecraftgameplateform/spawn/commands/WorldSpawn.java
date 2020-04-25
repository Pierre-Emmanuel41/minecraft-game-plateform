package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.worldstructure.CommonWorld;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class WorldSpawn extends CommonWorld<ISpawn> {

	protected WorldSpawn() {
		super(ESpawnMessageCode.WORLD_SPAWN__EXPLANATION);
	}

	@Override
	protected void onWorldNameIsMissing(CommandSender sender) {
		sendMessageToSender(sender, ESpawnMessageCode.WORLD_SPAWN__WORLD_NAME_IS_MISSING);
	}

	@Override
	protected void onWorldDefined(CommandSender sender, String name, String worldName) {
		sendMessageToSender(sender, ESpawnMessageCode.WORLD_SPAWN__WORLD_DEFINED, name, worldName);
	}
}
