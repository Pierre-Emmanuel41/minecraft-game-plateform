package fr.pederobien.minecraftgameplateform.commands.configurations.teams;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.add.AddFactory;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.ETeamConfigurationMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class CommonTeamAdd<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamAdd() {
		super(ETeamConfigurationLabel.ADD, ETeamConfigurationMessageCode.ADD__EXPLANATION);
		addEdition(AddFactory.addTeam());
	}
}
