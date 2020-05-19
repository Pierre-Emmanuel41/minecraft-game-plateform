package fr.pederobien.minecraftgameplateform.commands.configurations.borders;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.border.persistence.BorderPersistence;
import fr.pederobien.minecraftgameplateform.commands.configurations.AbstractGameConfigurationEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;
import fr.pederobien.persistence.interfaces.IPersistence;

public class AbstractBorderGameConfigurationEdition<T extends IGameBorderConfiguration> extends AbstractGameConfigurationEdition<T> {
	public static final IPersistence<IBorderConfiguration> PERSISTENCE = BorderPersistence.getInstance();

	protected AbstractBorderGameConfigurationEdition(ILabel label, IMinecraftMessageCode explanation) {
		super(label, explanation);
	}
}
