package fr.pederobien.minecraftgameplateform.border.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.border.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.commands.common.CommonSave;

public class SaveBorder extends CommonSave<IBorderConfiguration> {

	protected SaveBorder() {
		super(EBorderMessageCode.SAVE_BORDER__EXPLANATION);
	}

	@Override
	protected void onSave(CommandSender sender, String name) {
		sendMessageToSender(sender, EBorderMessageCode.SAVE_BORDER__BORDER_SAVED, name);
	}
}
