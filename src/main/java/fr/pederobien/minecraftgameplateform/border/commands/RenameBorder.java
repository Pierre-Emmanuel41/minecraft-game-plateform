package fr.pederobien.minecraftgameplateform.border.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.border.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.commands.common.CommonRename;

public class RenameBorder extends CommonRename<IBorderConfiguration> {

	protected RenameBorder() {
		super(EBorderMessageCode.RENAME_BORDER__EXPLANATION);
	}

	@Override
	protected void onNameAlreadyTaken(CommandSender sender, String currentName, String newName) {
		sendMessageToSender(sender, EBorderMessageCode.RENAME_BORDER__NAME_ALREADY_TAKEN, currentName, newName);
	}

	@Override
	protected void onNameIsMissing(CommandSender sender, String oldName) {
		sendMessageToSender(sender, EBorderMessageCode.RENAME_BORDER__NAME_IS_MISSING, oldName);
	}

	@Override
	protected void onRenamed(CommandSender sender, String oldName, String newName) {
		sendMessageToSender(sender, EBorderMessageCode.RENAME_BORDER__BORDER_RENAMED, oldName, newName);
	}
}
