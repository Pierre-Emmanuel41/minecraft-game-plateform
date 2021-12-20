package fr.pederobien.minecraft.game.platform.commands.configurations.teams;

import fr.pederobien.minecraft.game.platform.commands.configurations.teams.modify.ModifyFactory;
import fr.pederobien.minecraft.game.platform.dictionary.ETeamConfigurationMessageCode;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;

public class CommonTeamModify<T extends IGameConfiguration> extends AbstractTeamConfigurationEdition<T> {

	protected CommonTeamModify() {
		super(ETeamConfigurationLabel.MODIFY, ETeamConfigurationMessageCode.MODIFY__EXPLANATION);
		addEdition(ModifyFactory.modifyName());
		addEdition(ModifyFactory.modifyColor());
	}

}
