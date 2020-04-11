package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure.CommonLaunch;
import fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure.EWorldStructureLabel;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class LaunchSpawn extends CommonLaunch<ISpawn> {

	public LaunchSpawn() {
		super(ESpawnMessageCode.LAUNCH_SPAWN__EXPLANATION);
	}

	@Override
	protected void onLaunched(CommandSender sender, String name, int x, int y, int z) {
		sendMessageToSender(sender, ESpawnMessageCode.LAUNCH_SPAWN__SPAWN_LAUNCHED, name, x, y, z);
		setNewEditionAvailable(EWorldStructureLabel.REMOVE);
	}

	@Override
	protected void onNotExist(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.LAUNCH_SPAWN__SPAWN_DOES_NOT_EXIST, name);
	}
}
