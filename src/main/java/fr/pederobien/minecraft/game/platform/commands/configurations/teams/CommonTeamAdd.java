package fr.pederobien.minecraft.game.platform.commands.configurations.teams;

import fr.pederobien.minecraft.game.platform.commands.configurations.teams.add.AddFactory;
import fr.pederobien.minecraft.game.platform.dictionary.ETeamConfigurationCode;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

public class CommonTeamAdd<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamAdd() {
		super(ETeamConfigurationLabel.ADD, ETeamConfigurationCode.ADD__EXPLANATION);
		addEdition(AddFactory.addTeam());
		addEdition(AddFactory.addPlayer());
	}
}
