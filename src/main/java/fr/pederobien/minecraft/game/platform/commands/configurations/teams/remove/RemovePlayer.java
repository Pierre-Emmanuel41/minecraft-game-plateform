package fr.pederobien.minecraft.game.platform.commands.configurations.teams.remove;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.minecraft.game.platform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraft.game.platform.dictionary.ECommonCode;
import fr.pederobien.minecraft.game.platform.dictionary.ETeamRemoveCode;
import fr.pederobien.minecraft.game.platform.exceptions.PlayerNotFoundException;
import fr.pederobien.minecraft.game.platform.exceptions.configurations.PlayerNotRegisteredException;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;
import fr.pederobien.minecraft.game.platform.interfaces.helpers.IGameConfigurationHelper;

public class RemovePlayer<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected RemovePlayer() {
		super(ETeamRemoveLabel.PLAYER, ETeamRemoveCode.REMOVE_PLAYER__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<Player> players = new ArrayList<Player>();

		if (args[0].equals(IGameConfigurationHelper.ALL)) {
			for (ITeam team : get().getTeams())
				team.clear();
			sendSynchro(sender, ETeamRemoveCode.REMOVE_PLAYER__ALL_PLAYERS_REMOVED);
			return true;
		}

		String playerNamesConcatenated = null;
		List<ITeam> teams = null;
		try {
			players = getPlayers(args);
			playerNamesConcatenated = concat(getPlayerNames(players));
			teams = getGameConfigurationHelper().removePlayers(players);
		} catch (PlayerNotFoundException e) {
			sendSynchro(sender, ECommonCode.COMMON_PLAYER_DOES_NOT_EXIST, e.getPlayerName(), get().getName());
			return false;
		} catch (PlayerNotRegisteredException e) {
			sendSynchro(sender, ETeamRemoveCode.REMOVE_PLAYER__PLAYER_NOT_REGISTERED, e.getNotRegisteredPlayer().getName(), get().getName());
			return false;
		}

		switch (players.size()) {
		case 0:
			sendSynchro(sender, ETeamRemoveCode.REMOVE_PLAYER__ANY_PLAYER_REMOVED);
			break;
		case 1:
			sendSynchro(sender, ETeamRemoveCode.REMOVE_PLAYER__ONE_PLAYER_REMOVED, playerNamesConcatenated, getTeamNames(teams, true));
			break;
		default:
			sendSynchro(sender, ETeamRemoveCode.REMOVE_PLAYER__SEVERAL_PLAYERS_REMOVED, playerNamesConcatenated, getTeamNames(teams, true));
			break;
		}

		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		Stream<String> players = getNotFreePlayers(asList(args)).map(player -> player.getName());

		// Adding all to delete all registered players
		if (args.length == 1)
			return filter(Stream.concat(players, Stream.of(IGameConfigurationHelper.ALL)), args);

		// If the first argument is all -> any player is proposed
		// Else propose not already mentioned players
		return filter(args[0].equals(IGameConfigurationHelper.ALL) ? emptyStream() : players, args);
	}
}
