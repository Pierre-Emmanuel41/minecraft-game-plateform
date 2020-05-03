package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.worldstructure.CommonDimension;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.spawn.messages.ESpawnMessageCode;

public class DimensionSpawn extends CommonDimension<ISpawn> {

	protected DimensionSpawn() {
		super(ESpawnMessageCode.DIMENSION_SPAWN__EXPLANATION);
	}

	@Override
	protected void onDimensionDefined(CommandSender sender, String name, int width, int height, int depth) {
		sendMessageToSender(sender, ESpawnMessageCode.DIMENSION_SPAWN__DEFINED, name, width, height, depth);
	}
}
