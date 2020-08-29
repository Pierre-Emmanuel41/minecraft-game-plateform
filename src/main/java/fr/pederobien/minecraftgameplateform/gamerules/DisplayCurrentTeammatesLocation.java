package fr.pederobien.minecraftgameplateform.gamerules;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.bukkit.GameMode;
import org.bukkit.GameRule;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.EGameRuleMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftgameplateform.utils.TabCompleterFactory;
import fr.pederobien.minecraftmanagers.MessageManager;
import fr.pederobien.minecraftmanagers.MessageManager.DisplayOption;
import fr.pederobien.minecraftmanagers.MessageManager.TitleMessage;
import fr.pederobien.minecraftmanagers.TeamManager;
import fr.pederobien.minecraftmanagers.TeamManager.ColleagueInfo;
import fr.pederobien.minecraftmanagers.WorldManager;

public class DisplayCurrentTeammatesLocation extends PeriodicRunnableGameRule<Boolean> {

	public DisplayCurrentTeammatesLocation() {
		super("displayCurrentTeamMatesLocation", false, Boolean.class, EGameRuleMessageCode.DISPLAY_CURRENT_TEAMMATES_LOCATION__EXPLANATION);
		setCompleter(TabCompleterFactory.trueFalseCompleter());
	}

	@Override
	public void setValue(Boolean value) {
		super.setValue(value);
		if (isRunning() && !value)
			stop();
		else if (!isRunning() && Plateform.getGameConfigurationContext().isRunning() && value)
			start();
	}

	@Override
	public void start() {
		super.start();
		setSendCommandFeedBaskValue(false);
	}

	@Override
	public void stop() {
		super.stop();
		setSendCommandFeedBaskValue(true);
	}

	@Override
	public void run() {
		if (!getValue()) {
			stop();
			return;
		}

		for (ITeam team : Plateform.getGameConfigurationContext().getTeams()) {
			List<Player> players = team.getPlayers();
			for (Player player : players) {
				List<ColleagueInfo> colleagueInfos = TeamManager.getColleaguesInfo(player, p -> p.getGameMode().equals(GameMode.SURVIVAL)).collect(Collectors.toList());
				StringJoiner joiner = new StringJoiner(" ");
				for (ColleagueInfo info : colleagueInfos)
					joiner.add(info.getColleague().getName() + " : " + info.getDistance() + " | " + info.getArrow().getUnicode());

				if (joiner.toString().length() > 0)
					MessageManager.sendMessage(DisplayOption.ACTION_BAR, player, TitleMessage.of(joiner.toString(), "white"));
			}
		}
	}

	@Override
	public CommandExecutor getExecutor() {
		return new CommandExecutor() {
			@Override
			public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
				try {
					String value = args[0];
					if (value.equals("true"))
						setValue(true);
					else if (value.equals("false"))
						setValue(false);
					else {
						sendMessageToSender(sender, ECommonMessageCode.COMMON_BAD_BOOLEAN_FORMAT);
						return false;
					}
					sendMessageToSender(sender, EGameRuleMessageCode.COMMON_VALUE_DEFINED_IN_GAME, getName(), getValue());
				} catch (IndexOutOfBoundsException e) {
					sendMessageToSender(sender, EGameRuleMessageCode.COMMON_VALUE_IS_MISSING, getName());
					return false;
				}
				return true;
			}
		};
	}

	private void setSendCommandFeedBaskValue(boolean value) {
		WorldManager.OVERWORLD.setGameRule(GameRule.SEND_COMMAND_FEEDBACK, value);
		WorldManager.NETHER_WORLD.setGameRule(GameRule.SEND_COMMAND_FEEDBACK, value);
		WorldManager.END_WORLD.setGameRule(GameRule.SEND_COMMAND_FEEDBACK, value);
	}
}
