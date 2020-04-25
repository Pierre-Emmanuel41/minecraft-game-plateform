package fr.pederobien.minecraftgameplateform.commands.configurations;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.TeamEditionFactory;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.ETeamConfigurationMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class CommonTeam<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected CommonTeam() {
		super(EGameConfigurationLabel.TEAM, ETeamConfigurationMessageCode.TEAM__EXPLANATION);
		addEdition(TeamEditionFactory.commonTeamAdd());
		addEdition(TeamEditionFactory.commonTeamRemove());
	}
}