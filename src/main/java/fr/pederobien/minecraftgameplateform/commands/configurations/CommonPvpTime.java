package fr.pederobien.minecraftgameplateform.commands.configurations;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftdevelopmenttoolkit.utils.DisplayHelper;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.EGameConfigurationMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class CommonPvpTime<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected CommonPvpTime() {
		super(EGameConfigurationLabel.PVP_TIME, EGameConfigurationMessageCode.PVP_TIME__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			get().setPvpTime(LocalTime.parse(args[0]));
			if (get().getPvpTime().equals(LocalTime.of(0, 0, 0)))
				sendMessageToSender(sender, EGameConfigurationMessageCode.PVP_TIME__PVP_ENABLED_AT_THE_BEGINNING);
			else
				sendMessageToSender(sender, EGameConfigurationMessageCode.PVP_TIME__TIME_DEFINED, DisplayHelper.toString(get().getPvpTime()));
			return true;
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, EGameConfigurationMessageCode.PVP_TIME__TIME_IS_MISSING);
			return false;
		} catch (DateTimeParseException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_BAD_TIME_FORMAT);
			return false;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(getMessageFromDictionary(sender, ECommonMessageCode.COMMON_TIME_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
