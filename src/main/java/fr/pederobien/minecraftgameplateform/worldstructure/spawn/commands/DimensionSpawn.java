package fr.pederobien.minecraftgameplateform.worldstructure.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.worldstructure.commands.CommonDimension;

public class DimensionSpawn extends CommonDimension<ISpawn> {

	protected DimensionSpawn() {
		super(ESpawnMessageCode.DIMENSION_SPAWN__EXPLANATION);
	}

	@Override
	protected void onDimensionDefined(CommandSender sender, int width, int height, int depth) {
		sendMessageToSender(sender, ESpawnMessageCode.DIMENSION_SPAWN__DEFINED, width, height, depth);
	}
}
