package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.common.CommonRename;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class RenameSpawn extends CommonRename<ISpawn> {

	protected RenameSpawn() {
		super(ESpawnMessageCode.RENAME_SPAWN__EXPLANATION);
	}

	@Override
	protected void onNameAlreadyTaken(CommandSender sender, String currentName, String newName) {
		sendMessageToSender(sender, ESpawnMessageCode.RENAME_SPAWN__NAME_ALREADY_TAKEN, currentName, newName);
	}

	@Override
	protected void onNameIsMissing(CommandSender sender, String oldName) {
		sendMessageToSender(sender, ESpawnMessageCode.RENAME_SPAWN__NAME_IS_MISSING, oldName);
	}

	@Override
	protected void onRenamed(CommandSender sender, String oldName, String newName) {
		sendMessageToSender(sender, ESpawnMessageCode.RENAME_SPAWN__SPAWN_RENAMED, oldName, newName);
	}
}
