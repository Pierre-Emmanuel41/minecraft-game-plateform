package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.CommonDelete;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class DeleteSpawn extends CommonDelete<ISpawn> {

	protected DeleteSpawn() {
		super(ESpawnMessageCode.DELETE_SPAWN__EXPLANATION);
	}

	@Override
	protected void onDidNotDelete(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.DELETE_SPAWN__DIT_NOT_DELETE, name);
	}

	@Override
	protected void onDeleted(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.DELETE_SPAWN__SPAWN_DELETED, name);
	}

	@Override
	protected void onNameIsMissing(CommandSender sender) {
		sendMessageToSender(sender, ESpawnMessageCode.DELETE_SPAWN__NAME_IS_MISSING);
	}
}
