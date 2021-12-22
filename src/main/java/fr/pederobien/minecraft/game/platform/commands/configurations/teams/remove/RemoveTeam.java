package fr.pederobien.minecraft.game.platform.commands.configurations.teams.remove;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.platform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraft.game.platform.dictionary.ETeamRemoveCode;
import fr.pederobien.minecraft.game.platform.exceptions.configurations.TeamNotFoundException;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;
import fr.pederobien.minecraft.game.platform.interfaces.helpers.IGameConfigurationHelper;

public class RemoveTeam<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected RemoveTeam() {
		super(ETeamRemoveLabel.TEAM, ETeamRemoveCode.REMOVE_TEAM__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		List<ITeam> teams = new ArrayList<ITeam>();

		if (args[0].equals(IGameConfigurationHelper.ALL)) {
			List<String> teamNames = getTeamNames(getGameConfigurationHelper().clearTeams(), true);
			sendSynchro(sender, ETeamRemoveCode.REMOVE_TEAM__ALL_TEAMS_REMOVED, get().getName(), concat(teamNames, ", "));
			return true;
		}

		String teamNamesConcatenated = null;
		try {
			teams = getTeams(args);
			teamNamesConcatenated = concat(getTeamNames(teams, true));
			get().removeTeams(teams);
		} catch (TeamNotFoundException e) {
			sendSynchro(sender, ETeamRemoveCode.REMOVE_TEAM__TEAM_DOES_NOT_EXIST, e.getTeamNotFoundName(), get().getName());
			return false;
		}

		switch (teams.size()) {
		case 0:
			sendSynchro(sender, ETeamRemoveCode.REMOVE_TEAM__ANY_TEAM_REMOVED, get().getName());
			break;
		case 1:
			sendSynchro(sender, ETeamRemoveCode.REMOVE_TEAM__ONE_TEAM_REMOVED, teamNamesConcatenated, get().getName());
			break;
		default:
			sendSynchro(sender, ETeamRemoveCode.REMOVE_TEAM__SEVERAL_TEAMS_REMOVED, teamNamesConcatenated, get().getName());
			break;
		}
		return true;
	}

	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		Stream<String> teams = getFreeTeams(asList(args)).map(team -> team.getName());

		// Adding all to delete all registered teams
		if (args.length == 1)
			return filter(Stream.concat(teams, Stream.of(IGameConfigurationHelper.ALL)), args);

		// If the first argument is all -> any team is proposed
		// Else propose not already mentioned teams
		return filter(args[0].equals(IGameConfigurationHelper.ALL) ? emptyStream() : teams, args);
	}
}