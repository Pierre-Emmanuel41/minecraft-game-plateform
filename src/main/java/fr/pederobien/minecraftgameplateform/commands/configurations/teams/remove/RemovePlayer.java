package fr.pederobien.minecraftgameplateform.commands.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;
import fr.pederobien.minecraftgameplateform.commands.configurations.teams.AbstractTeamConfigurationEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class RemovePlayer<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected RemovePlayer(IMessageCode explanation) {
		super(ETeamRemoveLabel.PLAYER, explanation);
	}

}
