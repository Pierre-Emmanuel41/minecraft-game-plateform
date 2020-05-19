package fr.pederobien.minecraftgameplateform.commands.configurations.borders;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.commands.configurations.AbstractGameConfigurationEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;

public class BordersAdd<T extends IGameBorderConfiguration> extends AbstractGameConfigurationEdition<T> {

	protected BordersAdd(IMinecraftMessageCode explanation) {
		super(EBordersLabel.ADD, explanation);
	}

}
