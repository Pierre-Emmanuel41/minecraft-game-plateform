package fr.pederobien.minecraftgameplateform.commands.configurations.teams.remove;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.ETeamRemoveMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;

public class RemovePlayer<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected RemovePlayer() {
		super(ETeamRemoveLabel.PLAYER, ETeamRemoveMessageCode.REMOVE_PLAYER__EXPLANATION);
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		Stream<String> players = getNotFreePlayers(Arrays.asList(args)).map(player -> player.getName());

		// Adding all to delete all registered players
		if (args.length == 1)
			return filter(Stream.concat(players, Stream.of(IGameConfigurationHelper.ALL)), args[0]);

		// If the first argument is all -> any player is proposed
		// Else propose not already mentioned players
		return filter(args[0].equals(IGameConfigurationHelper.ALL) ? ((List<String>) emptyList()).stream() : players, args[args.length - 1]);
	}
}
