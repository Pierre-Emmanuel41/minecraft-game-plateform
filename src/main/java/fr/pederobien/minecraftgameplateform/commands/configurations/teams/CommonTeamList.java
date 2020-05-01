package fr.pederobien.minecraftgameplateform.commands.configurations.teams;

import java.util.StringJoiner;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.ETeamConfigurationMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;

public class CommonTeamList<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamList() {
		super(ETeamConfigurationLabel.LIST, ETeamConfigurationMessageCode.LIST__EXPLANATION);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		StringJoiner teams = new StringJoiner("\n");
		for (ITeam team : get().getTeams())
			teams.add(team.toString());

		switch (get().getTeams().size()) {
		case 0:
			sendMessageToSender(sender, ETeamConfigurationMessageCode.LIST__ANY_EXISTING_TEAM, get().getName());
			break;
		case 1:
			sendMessageToSender(sender, ETeamConfigurationMessageCode.LIST__ONE_EXISTING_TEAM, get().getName(), teams);
			break;
		default:
			sendMessageToSender(sender, ETeamConfigurationMessageCode.LIST__SEVERAL_EXISTING_TEAMS, get().getName(), teams);
			break;
		}
		return true;
	}
}
