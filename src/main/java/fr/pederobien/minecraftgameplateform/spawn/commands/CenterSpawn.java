package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.worldstructure.CommonCenter;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.spawn.messages.ESpawnMessageCode;

public class CenterSpawn extends CommonCenter<ISpawn> {

	public CenterSpawn() {
		super(ESpawnMessageCode.CENTER_SPAWN__EXPLANATION);
	}

	@Override
	protected void onCenterDefined(CommandSender sender, String name, int x, int y, int z) {
		sendMessageToSender(sender, ESpawnMessageCode.CENTER_SPAWN__CENTER_DEFINED, x, y, z);
	}
}
