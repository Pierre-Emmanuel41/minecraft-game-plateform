package fr.pederobien.minecraftgameplateform.commands.configurations;

import fr.pederobien.minecraftgameplateform.commands.configurations.borders.BordersEditionFactory;
import fr.pederobien.minecraftgameplateform.dictionary.EBordersMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;

public class CommonBorders<T extends IGameBorderConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected CommonBorders() {
		super(EGameConfigurationLabel.BORDERS, EBordersMessageCode.BORDERS__EXPLANATION);
		addEdition(BordersEditionFactory.addBorders());
	}
}
