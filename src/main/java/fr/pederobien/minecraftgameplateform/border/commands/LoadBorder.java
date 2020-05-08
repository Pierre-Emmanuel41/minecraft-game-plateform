package fr.pederobien.minecraftgameplateform.border.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.border.messages.EBorderMessageCode;
import fr.pederobien.minecraftgameplateform.commands.common.CommonLoad;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;

public class LoadBorder extends CommonLoad<IBorderConfiguration> {

	protected LoadBorder() {
		super(EBorderMessageCode.LOAD_BORDER__EXPLANATION);
	}

	@Override
	protected void onStyleLoaded(CommandSender sender, String name) {
		sendMessageToSender(sender, EBorderMessageCode.LOAD_BORDER__BORDER_LOADED, name);
	}

	@Override
	protected void onNameIsMissing(CommandSender sender) {
		sendMessageToSender(sender, EBorderMessageCode.LOAD_BORDER__NAME_IS_MISSING);
	}
}
