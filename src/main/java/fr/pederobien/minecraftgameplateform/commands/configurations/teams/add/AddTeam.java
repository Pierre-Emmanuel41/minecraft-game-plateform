package fr.pederobien.minecraftgameplateform.commands.configurations.teams.add;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.ETeamAddMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.ColorNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.PlayerNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNameForbiddenException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameColorAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamWithSameNameAlreadyExistsException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.utils.EColor;

public class AddTeam<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected AddTeam() {
		super(ETeamAddLabel.TEAM, ETeamAddMessageCode.ADD_TEAM__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String teamName = "";
		try {
			teamName = args[0];
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, ETeamAddMessageCode.ADD_TEAM__TEAM_NAME_IS_MISSING, get().getName());
			return false;
		}

		EColor teamColor = null;
		try {
			teamColor = getColor(args[1]);
		} catch (IndexOutOfBoundsException e) {
			sendMessageToSender(sender, ETeamAddMessageCode.ADD_TEAM__COLOR_NAME_IS_MISSING, teamName, get().getName());
			return false;
		} catch (ColorNotFoundException e) {
			sendMessageToSender(sender, ETeamAddMessageCode.ADD_TEAM__COLOR_DOES_NOT_EXIST, teamName, get().getName(), e.getColorName());
			return false;
		}

		ITeam team = null;
		try {
			team = getGameConfigurationHelper().create(teamName, teamColor);
			sendMessageToSender(sender, ETeamAddMessageCode.ADD_TEAM__TEAM_ADDED, team.getColoredName(), get().getName());
		} catch (TeamNameForbiddenException e) {
			sendMessageToSender(sender, ETeamAddMessageCode.ADD_TEAM__TEAM_NAME_FORBIDDEN, e.getForbiddenName(), get().getName());
			return false;
		} catch (TeamWithSameNameAlreadyExistsException e) {
			sendMessageToSender(sender, ETeamAddMessageCode.ADD_TEAM__TEAM_NAME_ALREADY_USED, e.getAlreadyExistingTeam().getColoredName(), get().getName());
			return false;
		} catch (TeamWithSameColorAlreadyExistsException e) {
			ITeam alreadyExistingTeam = e.getAlreadyExistingTeam();
			sendMessageToSender(sender, ETeamAddMessageCode.ADD_TEAM__COLOR_ALREADY_USED, alreadyExistingTeam.getColor().getName(), alreadyExistingTeam.getColoredName());
			return false;
		}

		String[] playerNames = extract(args, 2);
		String playerNamesConcatenated = null;
		List<Player> players = new ArrayList<Player>();
		try {
			players = getPlayers(playerNames);
			playerNamesConcatenated = concat(getPlayerNames(players));
			for (Player player : players)
				team.addPlayer(player);
		} catch (PlayerNotFoundException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON_PLAYER_DOES_NOT_EXIST, e.getPlayerName());
			return false;
		}

		switch (playerNames.length) {
		case 0:
			sendMessageToSender(sender, ETeamAddMessageCode.ADD_PLAYER__ANY_PLAYER_ADDED);
			break;
		case 1:
			sendMessageToSender(sender, ETeamAddMessageCode.ADD_PLAYER__ONE_PLAYER_ADDED, playerNamesConcatenated, team.getColoredName());
			break;
		default:
			sendMessageToSender(sender, ETeamAddMessageCode.ADD_PLAYER__SEVERAL_PLAYERS_ADDED, playerNamesConcatenated, team.getColoredName());
			break;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 0:
			return emptyList();
		case 1:
			return Arrays.asList(getMessageFromDictionary(sender, ECommonMessageCode.COMMON_NEW_TAB_COMPLETE));
		case 2:
			return filter(getFreeColorNames(false).stream(), args[1]);
		default:
			return filter(getFreePlayers(Arrays.asList(extract(args, 2))).map(player -> player.getName()), args[args.length - 1]);
		}
	}
}
