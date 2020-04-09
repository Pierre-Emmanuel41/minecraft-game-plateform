package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.CommonNew;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.spawn.Spawn;

public class NewSpawn extends CommonNew<ISpawn> {

	protected NewSpawn() {
		super(ESpawnMessageCode.NEW_SPAWN__EXPLANATION);
	}

	@Override
	protected void onNameAlreadyTaken(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.NEW_SPAWN__NAME_ALREADY_TAKEN, name);
	}

	@Override
	protected void onNameIsMissing(CommandSender sender) {
		sendMessageToSender(sender, ESpawnMessageCode.NEW_SPAWN__NAME_IS_MISSING);
	}

	@Override
	protected ISpawn create(String name) {
		return new Spawn(name);
	}

	@Override
	protected void onCreated(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.NEW_SPAWN__SPAWN_CREATED, name);
	}
}
