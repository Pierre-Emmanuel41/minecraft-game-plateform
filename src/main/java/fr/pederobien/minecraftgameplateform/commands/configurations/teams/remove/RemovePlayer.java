package fr.pederobien.minecraftgameplateform.commands.configurations.teams.remove;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.ETeamRemoveMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class RemovePlayer<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected RemovePlayer() {
		super(ETeamRemoveLabel.PLAYER, ETeamRemoveMessageCode.REMOVE_PLAYER__EXPLANATION);
	}

}
