package fr.pederobien.minecraftgameplateform.commands.configurations.teams.remove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.ETeamRemoveMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.PlayerNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.PlayerNotRegisteredException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;

public class RemovePlayer<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected RemovePlayer() {
		super(ETeamRemoveLabel.PLAYER, ETeamRemoveMessageCode.REMOVE_PLAYER__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<Player> players = new ArrayList<Player>();

		if (args[0].equals(IGameConfigurationHelper.ALL)) {
			sendMessageToSender(sender, ETeamRemoveMessageCode.REMOVE_PLAYER__ALL_PLAYERS_REMOVED);
			return true;
		}

		String playerNamesConcatenated = null;
		List<ITeam> teams = null;
		try {
			players = getPlayers(args);
			playerNamesConcatenated = concat(getPlayerNames(players));
			teams = getGameConfigurationHelper().removePlayers(players);
		} catch (PlayerNotFoundException e) {
			sendMessageToSender(sender, ECommonMessageCode.COMMON__PLAYER_DOES_NOT_EXIST, e.getPlayerName(), get().getName());
			return false;
		} catch (PlayerNotRegisteredException e) {
			sendMessageToSender(sender, ETeamRemoveMessageCode.REMOVE_PLAYER__PLAYER_NOT_REGISTERED, e.getNotRegisteredPlayer().getName(), get().getName());
			return false;
		}

		switch (players.size()) {
		case 0:
			sendMessageToSender(sender, ETeamRemoveMessageCode.REMOVE_PLAYER__ANY_PLAYER_REMOVED);
			break;
		case 1:
			sendMessageToSender(sender, ETeamRemoveMessageCode.REMOVE_PLAYER__ONE_PLAYER_REMOVED, playerNamesConcatenated, getTeamNames(teams, true));
			break;
		default:
			sendMessageToSender(sender, ETeamRemoveMessageCode.REMOVE_PLAYER__SEVERAL_PLAYERS_REMOVED, playerNamesConcatenated, getTeamNames(teams, true));
			break;
		}

		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		Stream<String> players = getNotFreePlayers(Arrays.asList(args)).map(player -> player.getName());

		// Adding all to delete all registered players
		if (args.length == 1)
			return filter(Stream.concat(players, Stream.of(IGameConfigurationHelper.ALL)), args[0]);

		// If the first argument is all -> any player is proposed
		// Else propose not already mentioned players
		return filter(args[0].equals(IGameConfigurationHelper.ALL) ? emptyStream() : players, args[args.length - 1]);
	}
}
