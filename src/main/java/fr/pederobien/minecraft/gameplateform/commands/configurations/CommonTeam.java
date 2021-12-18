package fr.pederobien.minecraft.gameplateform.commands.configurations;

import fr.pederobien.minecraft.gameplateform.commands.configurations.teams.TeamEditionFactory;
import fr.pederobien.minecraft.gameplateform.dictionary.ETeamConfigurationMessageCode;
import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;

public class CommonTeam<T extends IGameConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected CommonTeam() {
		super(EGameConfigurationLabel.TEAM, ETeamConfigurationMessageCode.TEAM__EXPLANATION);
		addEdition(TeamEditionFactory.commonTeamAdd());
		addEdition(TeamEditionFactory.commonTeamRemove());
		addEdition(TeamEditionFactory.commonTeamModify());
		addEdition(TeamEditionFactory.commonTeamList());
		addEdition(TeamEditionFactory.commonTeamMove());
		addEdition(TeamEditionFactory.commonTeamRandom());
	}
}
