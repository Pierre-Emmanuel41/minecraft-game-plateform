package fr.pederobien.minecraft.game.platform.commands.configurations.teams;

import java.util.List;
import java.util.StringJoiner;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.platform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraft.game.platform.dictionary.ETeamConfigurationMessageCode;
import fr.pederobien.minecraft.game.platform.exceptions.configurations.RandomTeamNotEnoughPlayer;
import fr.pederobien.minecraft.game.platform.exceptions.configurations.RandomTeamNotEnoughTeam;
import fr.pederobien.minecraft.game.platform.helpers.TeamHelper;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;

public class CommonTeamRandom<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamRandom() {
		super(ETeamConfigurationLabel.RANDOM, ETeamConfigurationMessageCode.TEAM_RANDOM__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		int maxPlayerInTeam;
		try {
			if (args.length == 1) {
				maxPlayerInTeam = Integer.parseInt(args[0]);
				if (maxPlayerInTeam <= 0) {
					sendSynchro(sender, ETeamConfigurationMessageCode.TEAM_RANDOM__MAX_PLAYER_NEGATIVE);
					return false;
				}
			} else
				maxPlayerInTeam = -1;

			TeamHelper.dispatchPlayerRandomlyInTeam(get(), maxPlayerInTeam);

			StringJoiner joiner = new StringJoiner("\n");
			for (ITeam team : get().getTeams())
				if (!team.getPlayers().isEmpty())
					joiner.add(team.toString());
			sendSynchro(sender, ETeamConfigurationMessageCode.TEAM_RANDOM__PLAYERS_DISPATCHED, joiner.toString());
		} catch (NumberFormatException e) {
			sendSynchro(sender, ECommonMessageCode.COMMON_BAD_INTEGER_FORMAT);
			return false;
		} catch (RandomTeamNotEnoughPlayer e) {
			sendSynchro(sender, ETeamConfigurationMessageCode.TEAM_RANDOM__NOT_ENOUGH_PLAYERS, e.getPlayersCount());
			return false;
		} catch (RandomTeamNotEnoughTeam e) {
			sendSynchro(sender, ETeamConfigurationMessageCode.TEAM_RANDOM__NOT_ENOUGH_TEAMS, get().getName(), e.getTeamCount());
			return false;
		}
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		switch (args.length) {
		case 1:
			return asList(getMessage(sender, ETeamConfigurationMessageCode.TEAM_RANDOM__ON_TAB_COMPLETE));
		default:
			return emptyList();
		}
	}
}
