package fr.pederobien.minecraftgameplateform.commands.configurations.teams.remove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.ETeamRemoveMessageCode;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;

public class RemoveTeam<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected RemoveTeam() {
		super(ETeamRemoveLabel.TEAM, ETeamRemoveMessageCode.REMOVE_TEAM__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<ITeam> teams = new ArrayList<ITeam>();

		if (args[0].equals(IGameConfigurationHelper.ALL)) {
			List<String> teamNames = getTeamNames(getGameConfigurationHelper().clearTeams());
			sendMessageToSender(sender, ETeamRemoveMessageCode.REMOVE_TEAM__ALL_TEAMS_REMOVED, get().getName(), concat(teamNames, ", "));
			return true;
		}

		String teamNamesConcatenated = null;
		try {
			teams = getTeams(args);
			teamNamesConcatenated = concat(getTeamNames(teams));
			get().remove(teams);
		} catch (TeamNotFoundException e) {
			sendMessageToSender(sender, ETeamRemoveMessageCode.REMOVE_TEAM__TEAM_DOES_NOT_EXIST, e.getTeamNotFoundName(), get().getName());
			return false;
		}

		switch (teams.size()) {
		case 0:
			sendMessageToSender(sender, ETeamRemoveMessageCode.REMOVE_TEAM__ANY_TEAM_REMOVED, get().getName());
			break;
		case 1:
			sendMessageToSender(sender, ETeamRemoveMessageCode.REMOVE_TEAM__ONE_TEAM_REMOVED, teamNamesConcatenated, get().getName());
			break;
		default:
			sendMessageToSender(sender, ETeamRemoveMessageCode.REMOVE_TEAM__SEVERAL_TEAMS_REMOVED, teamNamesConcatenated, get().getName());
			break;
		}
		return true;
	}

	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		Stream<String> teams = getFreeTeams(Arrays.asList(args)).map(team -> team.getName());

		// Adding all to delete all registered teams
		if (args.length == 1)
			return filter(Stream.concat(teams, Stream.of(IGameConfigurationHelper.ALL)), args[0]);

		// If the first argument is all -> any team is proposed
		// Else propose not already mentioned teams
		return filter(args[0].equals(IGameConfigurationHelper.ALL) ? ((List<String>) emptyList()).stream() : teams, args[args.length - 1]);
	}
}
