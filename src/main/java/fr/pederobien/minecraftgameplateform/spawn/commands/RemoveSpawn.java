package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure.CommonRemove;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class RemoveSpawn extends CommonRemove<ISpawn> {

	protected RemoveSpawn() {
		super(ESpawnMessageCode.REMOVE_SPAWN__EXPLANATION);
	}

	@Override
	protected void onRemoved(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.REMOVE_SPAWN__SPAWN_REMOVED, name);
	}
}
