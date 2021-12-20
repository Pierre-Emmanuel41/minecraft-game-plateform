package fr.pederobien.minecraft.game.platform.commands.configurations;

import fr.pederobien.minecraft.game.platform.commands.configurations.teams.TeamEditionFactory;
import fr.pederobien.minecraft.game.platform.dictionary.ETeamConfigurationMessageCode;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

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
