package fr.pederobien.minecraft.game.platform.commands.configurations.teams;

import fr.pederobien.minecraft.game.platform.commands.configurations.teams.remove.RemoveFactory;
import fr.pederobien.minecraft.game.platform.dictionary.ETeamConfigurationCode;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

public class CommonTeamRemove<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamRemove() {
		super(ETeamConfigurationLabel.REMOVE, ETeamConfigurationCode.REMOVE__EXPLANATION);
		addEdition(RemoveFactory.removeTeam());
		addEdition(RemoveFactory.removePlayer());
	}
}
