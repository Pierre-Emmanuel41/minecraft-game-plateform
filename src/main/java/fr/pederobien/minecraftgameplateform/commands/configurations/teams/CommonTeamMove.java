package fr.pederobien.minecraftgameplateform.commands.configurations.teams;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.ETeamConfigurationMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.PlayerNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.PlayerNotRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamsAreTheSameException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftmanagers.PlayerManager;

public class CommonTeamMove<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamMove() {
		super(ETeamConfigurationLabel.MOVE, ETeamConfigurationMessageCode.MOVE__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String playerName = "";
		String teamName = "";
		try {
			try {
				playerName = args[0];
			} catch (IndexOutOfBoundsException e) {
				sendMessageToSender(sender, ETeamConfigurationMessageCode.MOVE__PLAYER_NAME_IS_MISSING);
				return false;
			}
			try {
				teamName = args[1];
			} catch (IndexOutOfBoundsException e) {
				sendMessageToSender(sender, ETeamConfigurationMessageCode.MOVE__TEAM_NAME_IS_MISSING, playerName);
				return false;
			}

			ITeam[] teams = getGameConfigurationHelper().movePlayer(playerName, teamName);
			sendMessageToSender(sender, ETeamConfigurationMessageCode.MOVE__PLAYER_MOVED, playerName, teams[1].getColoredName(), teams[0].getColoredName());
			return true;
		} catch (PlayerNotFoundException e) {
			sendMessageToSender(sender, ETeamConfigurationMessageCode.MOVE__PLAYER_DOES_NOT_EXIST, e.getPlayerName());
			return false;
		} catch (PlayerNotRegisteredException e) {
			sendMessageToSender(sender, ETeamConfigurationMessageCode.MOVE__PLAYER_NOT_REGISTERED, e.getNotRegisteredPlayer().getName());
			return false;
		} catch (TeamNotFoundException e) {
			sendMessageToSender(sender, ETeamConfigurationMessageCode.MOVE__TEAM_DOES_NOT_EXIST, playerName, e.getTeamNotFoundName(), get().getName());
			return false;
		} catch (TeamsAreTheSameException e) {
			sendMessageToSender(sender, ETeamConfigurationMessageCode.MOVE__TEAMS_ARE_THE_SAME, playerName, e.getTargetTeam().getColoredName());
			return false;
		}
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return filter(getGameConfigurationHelper().getNotFreePlayers().map(player -> player.getName()), args);
		case 2:
			return filter(check(args[0], e -> PlayerManager.getPlayer(e) != null, getOtherTeamNames(args[0])), args);
		}
		return super.onTabComplete(sender, command, alias, args);
	}
}
