package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.ECommonLabel;
import fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure.CommonExtract;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class ExtractSpawn extends CommonExtract<ISpawn> {

	protected ExtractSpawn() {
		super(ESpawnMessageCode.EXTRACT_SPAWN__EXPLANATION);
	}

	@Override
	protected void onExtracted(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.EXTRACT_SPAWN__SPAWN_EXTRACTED, name);
		setAvailableLabelEdition(ECommonLabel.SAVE);
	}
}
