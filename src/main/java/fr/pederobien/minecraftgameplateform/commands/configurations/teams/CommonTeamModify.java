package fr.pederobien.minecraftgameplateform.commands.configurations.teams;

import fr.pederobien.minecraftgameplateform.commands.configurations.teams.modify.ModifyFactory;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.ETeamConfigurationMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class CommonTeamModify<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamModify() {
		super(ETeamConfigurationLabel.MODIFY, ETeamConfigurationMessageCode.MODIFY__EXPLANATION);
		addEdition(ModifyFactory.modifyName());
	}

}
