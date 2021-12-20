package fr.pederobien.minecraft.game.platform.impl.editions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.platform.Platform;
import fr.pederobien.minecraft.game.platform.dictionary.ECommonCode;
import fr.pederobien.minecraftdevelopmenttoolkit.exceptions.ArgumentNotFoundException;
import fr.pederobien.minecraftdevelopmenttoolkit.exceptions.NotAvailableArgumentException;
import fr.pederobien.minecraftdevelopmenttoolkit.impl.messagecode.AbstractMessageCodeSimpleMapEdition;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;

public class AbstractSimpleMapEdition extends AbstractMessageCodeSimpleMapEdition {

	public AbstractSimpleMapEdition(String label, IMinecraftMessageCode explanation) {
		super(label, explanation);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			return super.onCommand(sender, command, label, args);
		} catch (ArgumentNotFoundException e) {
			sendSynchro(sender, ECommonCode.COMMON_ARGUMENT_NOT_FOUND, e.getNotFoundArgument(), e.getLabel());
		} catch (NotAvailableArgumentException e) {
			sendSynchro(sender, ECommonCode.COMMON_NOT_AVAILABLE_ARGUMENT, e.getArgument(), e.getLabel());
		}
		return false;
	}

	@Override
	public IMinecraftNotificationCenter getNotificationCenter() {
		return Platform.getNotificationCenter();
	}
}
