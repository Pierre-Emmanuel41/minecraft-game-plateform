package fr.pederobien.minecraftgameplateform.spawn.commands;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftdevelopmenttoolkit.managers.BukkitManager;
import fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure.AbstractWorldStructureEdition;
import fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure.EWorldStructureLabel;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class RandomSpawn extends AbstractWorldStructureEdition<ISpawn> {

	protected RandomSpawn() {
		super(ESpawnLabel.RANDOM, ESpawnMessageCode.RANDOM_SPAWN__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<String> spawns = getPersistence().list();
		String name = spawns.get(new Random().nextInt(spawns.size()));
		if (get() != null) {
			get().remove();
			getPersistence().save();
		}
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add("spawn").add(EWorldStructureLabel.LAUNCH.getLabel()).add(name);
		for (String arg : args)
			joiner.add(arg);
		BukkitManager.dispatchCommand(joiner.toString());
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			// Check if the first argument is an integer
			return check(args[0], e -> isInt(e), Arrays.asList("<X> <Y> <Z>"));
		case 2:
			// Check if the second argument is an integer
			return check(args[1], e -> isInt(e), check(args[0], e -> isInt(e), Arrays.asList("<Y> <Z>")));
		case 3:
			// Check if the third argument is an integer
			return check(args[2], e -> isInt(e), check(args[1], e -> isInt(e), Arrays.asList("<Z>")));
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
