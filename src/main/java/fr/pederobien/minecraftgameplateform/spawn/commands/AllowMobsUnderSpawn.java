package fr.pederobien.minecraftgameplateform.spawn.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.worldstructure.AbstractWorldStructureEdition;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.spawn.messages.ESpawnMessageCode;

public class AllowMobsUnderSpawn extends AbstractWorldStructureEdition<ISpawn> {

	protected AllowMobsUnderSpawn() {
		super(ESpawnLabel.ALLOW_MOBS_TO_SPAWN_UNDER_SPAWN, ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			String isAllowMobsUnderSpawn = args[0];
			if (isAllowMobsUnderSpawn.equals("true"))
				get().setAllowMobsUnderSpawn(true);
			else if (isAllowMobsUnderSpawn.equals("false"))
				get().setAllowMobsUnderSpawn(false);
			else {
				sendMessageToSender(sender, ECommonMessageCode.COMMON__BAD_BOOLEAN_FORMAT);
				return false;
			}
			sendMessageToSender(sender, ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__DEFINED, get().isAllowMobsUnderSpawn());
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, ESpawnMessageCode.ALLOW_MOB_TO_SPAWN_UNDER_SPAWN__VALUE_IS_MISSING);
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return filter(Arrays.asList("true", "false").stream(), args[0]);
		return super.onTabComplete(sender, command, alias, args);
	}
}
