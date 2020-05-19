package fr.pederobien.minecraftgameplateform.commands.configurations.borders;

import fr.pederobien.minecraftgameplateform.commands.configurations.AbstractGameConfigurationEdition;
import fr.pederobien.minecraftgameplateform.dictionary.EBordersMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;

public class BordersAdd<T extends IGameBorderConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected BordersAdd() {
		super(EBordersLabel.ADD, EBordersMessageCode.BORDERS_ADD__EXPLANATION);
	}

}
