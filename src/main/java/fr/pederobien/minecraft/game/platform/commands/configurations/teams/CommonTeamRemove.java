package fr.pederobien.minecraft.game.platform.commands.configurations.teams;

import fr.pederobien.minecraft.game.platform.commands.configurations.teams.remove.RemoveFactory;
import fr.pederobien.minecraft.game.platform.dictionary.ETeamConfigurationMessageCode;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

public class CommonTeamRemove<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamRemove() {
		super(ETeamConfigurationLabel.REMOVE, ETeamConfigurationMessageCode.REMOVE__EXPLANATION);
		addEdition(RemoveFactory.removeTeam());
		addEdition(RemoveFactory.removePlayer());
	}
}
