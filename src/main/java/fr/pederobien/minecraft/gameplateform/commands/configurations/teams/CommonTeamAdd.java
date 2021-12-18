package fr.pederobien.minecraft.gameplateform.commands.configurations.teams;

import fr.pederobien.minecraft.gameplateform.commands.configurations.teams.add.AddFactory;
import fr.pederobien.minecraft.gameplateform.dictionary.ETeamConfigurationMessageCode;
import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;

public class CommonTeamAdd<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamAdd() {
		super(ETeamConfigurationLabel.ADD, ETeamConfigurationMessageCode.ADD__EXPLANATION);
		addEdition(AddFactory.addTeam());
		addEdition(AddFactory.addPlayer());
	}
}
