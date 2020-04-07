package fr.pederobien.minecraftgameplateform.worldstructure.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.worldstructure.commands.CommonDimension;

public class DimensionSpawn extends CommonDimension<ISpawn> {

	public DimensionSpawn() {
		super(ESpawnMessageCode.DIMENSION_SPAWN_EXPLANATION);
	}

	@Override
	protected void onDimensionDefined(CommandSender sender, int width, int height, int depth) {
		sendMessageToSender(sender, ESpawnMessageCode.DIMENSION_SPAWN_DEFINED, width, height, depth);
	}
}