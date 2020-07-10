package fr.pederobien.minecraftgameplateform.gamerules;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.dictionary.EGameRuleMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.MessageManager;
import fr.pederobien.minecraftmanagers.MessageManager.DisplayOption;
import fr.pederobien.minecraftmanagers.MessageManager.TitleMessage;
import fr.pederobien.minecraftmanagers.TeamManager;
import fr.pederobien.minecraftmanagers.TeamManager.ColleagueInfo;

public class DisplayCurrentTeammatesLocation extends RunnableGameRule<Boolean> {

	public DisplayCurrentTeammatesLocation() {
		super("currentTeamMatesLocation", false, Boolean.class, EGameRuleMessageCode.DISPLAY_CURRENT_TEAMMATES_LOCATION);
	}

	@Override
	public void setValue(Boolean value) {
		super.setValue(value);
		if (isRunning() && !value)
			stop();
		else if (!isRunning() && value)
			start();
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
				MessageManager.sendMessage(DisplayOption.ACTION_BAR, player, TitleMessage.of(joiner.toString(), "white"));
			}
		}
	}
}
