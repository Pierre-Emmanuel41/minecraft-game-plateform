package fr.pederobien.minecraftgameplateform.commands.configurations.teams.add;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.ETeamAddMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.PlayerNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.PlayerAlreadyRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;

public class AddPlayer<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected AddPlayer() {
		super(ETeamAddLabel.PLAYER, ETeamAddMessageCode.ADD_PLAYER__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String name = "";
		try {
			name = args[0];
		} catch (IndexOutOfBoundsException e) {
			sendSynchro(sender, ETeamAddMessageCode.ADD_PLAYER__TEAM_NAME_IS_MISSING);
			return false;
		}

		String[] playerNames = extract(args, 1);
		String playerNamesConcatenated = null;
		ITeam team = null;
		List<Player> players = new ArrayList<Player>();

		try {
			players = getPlayers(playerNames);
			playerNamesConcatenated = concat(getPlayerNames(players));
			team = getGameConfigurationHelper().add(name, players);
		} catch (PlayerNotFoundException e) {
			sendSynchro(sender, ECommonMessageCode.COMMON_PLAYER_DOES_NOT_EXIST, e.getPlayerName());
			return false;
		} catch (TeamNotFoundException e) {
			sendSynchro(sender, ETeamAddMessageCode.ADD_PLAYER__TEAM_DOES_NOT_EXIST, name, get().getName());
			return false;
		} catch (PlayerAlreadyRegisteredException e) {
			sendSynchro(sender, ETeamAddMessageCode.ADD_PLAYER__PLAYER_ALREADY_REGISTERED, e.getAlreadyRegisteredPlayer(), team, e.getTeam());
		}

		switch (playerNames.length) {
		case 0:
			sendSynchro(sender, ETeamAddMessageCode.ADD_PLAYER__ANY_PLAYER_ADDED);
			break;
		case 1:
			sendSynchro(sender, ETeamAddMessageCode.ADD_PLAYER__ONE_PLAYER_ADDED, playerNamesConcatenated, team.getColoredName());
			break;
		default:
			sendSynchro(sender, ETeamAddMessageCode.ADD_PLAYER__SEVERAL_PLAYERS_ADDED, playerNamesConcatenated, team.getColoredName());
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
			return filter(getGameConfigurationHelper().getTeamNames(false), args);
		default:
			return filter(getFreePlayers(asList(extract(args, 1))).map(player -> player.getName()), args);
		}
	}
}
