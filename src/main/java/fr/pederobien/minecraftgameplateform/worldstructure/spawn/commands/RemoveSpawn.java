package fr.pederobien.minecraftgameplateform.worldstructure.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.worldstructure.commands.CommonRemove;

public class RemoveSpawn extends CommonRemove<ISpawn> {

	protected RemoveSpawn() {
		super(ESpawnMessageCode.REMOVE_SPAWN__EXPLANATION);
	}

	@Override
	protected void onRemoved(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.REMOVE_SPAWN__SPAWN_REMOVED, name);
	}
}
