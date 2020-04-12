package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.CommonSave;
import fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure.EWorldStructureLabel;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class SaveSpawn extends CommonSave<ISpawn> {

	protected SaveSpawn() {
		super(ESpawnMessageCode.SAVE_SPAWN__EXPLANATION);
	}

	@Override
	protected void onSave(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.SAVE_SPAWN__SPAWN_SAVED, name);
		setNewEditionAvailable(EWorldStructureLabel.LAUNCH);
	}
}
