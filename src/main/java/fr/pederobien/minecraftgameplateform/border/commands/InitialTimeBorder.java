package fr.pederobien.minecraftgameplateform.border.commands;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;

public class InitialTimeBorder extends AbstractLabelEdition<IBorderConfiguration> {

	protected InitialTimeBorder() {
		super(EBorderLabel.INITIAL_TIME, EBorderMessageCode.INITIAL_TIME_BORDER__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			get().setInitialTime(LocalTime.parse(args[0]));
			if (get().getInitialTime().equals(LocalTime.of(0, 0, 0))) {
				sendMessageToSender(sender, EBorderMessageCode.INITIAL_TIME_BORDER__INITIAL_DIAMETER_AT_THE_BEGINNING, get().getName());
				return true;
			}
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, EBorderMessageCode.INITIAL_TIME_BORDER__TIME_IS_MISSING);
			return false;
		} catch (DateTimeParseException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_BAD_TIME_FORMAT);
			return false;
		}

		sendMessageToSender(sender, EBorderMessageCode.INITIAL_TIME_BORDER__TIME_DEFINED, get().getName(), toString(get().getInitialTime()));
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(getMessageFromDictionary(sender, ECommonMessageCode.COMMON_TIME_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
