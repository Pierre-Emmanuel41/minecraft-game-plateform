package fr.pederobien.minecraft.gameplateform.commands.configurations.teams;

import fr.pederobien.minecraft.gameplateform.commands.configurations.teams.remove.RemoveFactory;
import fr.pederobien.minecraft.gameplateform.dictionary.ETeamConfigurationMessageCode;
import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;

public class CommonTeamRemove<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamRemove() {
		super(ETeamConfigurationLabel.REMOVE, ETeamConfigurationMessageCode.REMOVE__EXPLANATION);
		addEdition(RemoveFactory.removeTeam());
		addEdition(RemoveFactory.removePlayer());
	}
}
