package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.common.CommonSave;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class SaveSpawn extends CommonSave<ISpawn> {

	protected SaveSpawn() {
		super(ESpawnMessageCode.SAVE_SPAWN__EXPLANATION);
	}

	@Override
	protected void onSave(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.SAVE_SPAWN__SPAWN_SAVED, name);
	}
}
