package fr.pederobien.minecraftgameplateform.commands.configurations.teams;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.remove.RemoveFactory;
import fr.pederobien.minecraftgameplateform.dictionary.ETeamConfigurationMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class CommonTeamRemove<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamRemove() {
		super(ETeamConfigurationLabel.REMOVE, ETeamConfigurationMessageCode.REMOVE__EXPLANATION);
		addEdition(RemoveFactory.removeTeam());
		addEdition(RemoveFactory.removePlayer());
	}
}
