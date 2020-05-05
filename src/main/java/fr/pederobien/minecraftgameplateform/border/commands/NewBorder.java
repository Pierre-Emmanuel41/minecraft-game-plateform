package fr.pederobien.minecraftgameplateform.border.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.border.BorderConfiguration;
import fr.pederobien.minecraftgameplateform.border.messages.EBorderMessageCode;
import fr.pederobien.minecraftgameplateform.commands.common.CommonNew;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;

public class NewBorder extends CommonNew<IBorderConfiguration> {

	protected NewBorder() {
		super(EBorderMessageCode.NEW_BORDER__EXPLANATION);
	}

	@Override
	protected void onNameAlreadyTaken(CommandSender sender, String name) {
		sendMessageToSender(sender, EBorderMessageCode.NEW_BORDER__NAME_ALREADY_TAKEN, name);
	}

	@Override
	protected void onNameIsMissing(CommandSender sender) {
		sendMessageToSender(sender, EBorderMessageCode.NEW_BORDER__NAME_IS_MISSING);
	}

	@Override
	protected IBorderConfiguration create(String name) {
		return new BorderConfiguration(name);
	}

	@Override
	protected void onCreated(CommandSender sender, String name) {
		sendMessageToSender(sender, EBorderMessageCode.NEW_BORDER__BORDER_CREATED, name);
	}
}