package fr.pederobien.minecraftgameplateform.impl.editions;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.commands.configurations.GameConfigurationEditionFactory;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;

public abstract class AbstractGameBorderConfigurationParent<T extends IGameBorderConfiguration> extends AbstractGameConfigurationParent<T> {

	public AbstractGameBorderConfigurationParent(String label, IMinecraftMessageCode explanation, Plugin plugin, IMinecraftPersistence<T> persistence) {
		super(label, explanation, plugin, persistence);

		addEdition(GameConfigurationEditionFactory.bordersEdition());
	}
}
