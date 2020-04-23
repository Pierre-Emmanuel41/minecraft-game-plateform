package fr.pederobien.minecraftgameplateform.commands.configurations;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.EGameConfigurationMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class CommonScoreboardRefresh<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected CommonScoreboardRefresh() {
		super(EGameConfigurationLabel.SCOREBOARD_REFRESH, EGameConfigurationMessageCode.SCOREBOARD_REFRESH__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			Long refresh = Long.parseLong(args[0]);
			if (refresh < 0) {
				sendMessageToSender(sender, EGameConfigurationMessageCode.SCOREBOARD_REFRESH__NEGATIVE_TICS_NUMBER);
				return false;
			}

			if (refresh == 1) {
				get().setScoreboardRefresh(refresh);
				sendMessageToSender(sender, EGameConfigurationMessageCode.SCOREBOARD_REFRESH__ONE_TICK_DEFINED);
				return true;
			}

			get().setScoreboardRefresh(refresh);
			sendMessageToSender(sender, EGameConfigurationMessageCode.SCOREBOARD_REFRESH__SEVERAL_TICS_DEFINED, refresh);
			return true;
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, EGameConfigurationMessageCode.SCOREBOARD_REFRESH__TICS_NUMBER_IS_MISSING);
			return false;
		} catch (NumberFormatException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT);
			return false;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
			return Arrays.asList(getMessageFromDictionary(sender, EGameConfigurationMessageCode.SCOREBOARD_REFRESH__ON_TAB_COMPLETE));
		return super.onTabComplete(sender, command, alias, args);
	}
}
