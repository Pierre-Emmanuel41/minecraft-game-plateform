package fr.pederobien.minecraftgameplateform.commands.configurations;

import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;
import fr.pederobien.minecraftgameplateform.interfaces.helpers.IGameConfigurationHelper;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class AbstractGameConfigurationEdition<T extends IGameConfiguration> extends AbstractLabelEdition<T> {

	protected AbstractGameConfigurationEdition(ILabel label, IMessageCode explanation) {
		super(label, explanation);
	}

	/**
	 * @return An helper to simplify manipulation of a game configuration.
	 */
	protected IGameConfigurationHelper getGameConfigurationHelper() {
		return Plateform.getOrCreateConfigurationHelper(get());
	}
}
