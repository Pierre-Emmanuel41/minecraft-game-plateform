package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure.CommonCenter;
import fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure.EWorldStructureLabel;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class CenterSpawn extends CommonCenter<ISpawn> {

	public CenterSpawn() {
		super(ESpawnMessageCode.CENTER_SPAWN__EXPLANATION);
	}

	@Override
	protected void onCenterDefined(CommandSender sender, String name, int x, int y, int z) {
		sendMessageToSender(sender, ESpawnMessageCode.CENTER_SPAWN__CENTER_DEFINED, x, y, z);
		setNewEditionAvailable(EWorldStructureLabel.DIMENSION);
	}
}
