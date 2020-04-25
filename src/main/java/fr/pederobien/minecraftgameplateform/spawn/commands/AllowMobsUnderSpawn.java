package fr.pederobien.minecraftgameplateform.spawn.commands;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.worldstructure.AbstractWorldStructureEdition;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class AllowMobsUnderSpawn extends AbstractWorldStructureEdition<ISpawn> {

	protected AllowMobsUnderSpawn() {
		super(ESpawnLabel.ALLOW_MOBS_UNDER_SPAWN, ESpawnMessageCode.ALLOW_MOB_UNDER_SPAWN__EXPLANATION);
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
				return false;
			}
		} catch (IndexOutOfBoundsException e) {
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
