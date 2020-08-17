package fr.pederobien.minecraftgameplateform.impl.editions;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.commands.configurations.GameConfigurationEditionFactory;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;

public abstract class AbstractGameConfigurationParent<T extends IGameConfiguration> extends AbstractConfigurationParentPersistenceEdition<T> {

	public AbstractGameConfigurationParent(String label, IMinecraftMessageCode explanation, Plugin plugin, IMinecraftPersistence<T> persistence) {
		super(label, explanation, plugin, persistence);

		addEdition(GameConfigurationEditionFactory.asCurrentEdition());
		addEdition(GameConfigurationEditionFactory.teamEdition());
		addEdition(GameConfigurationEditionFactory.pvpTime());
	}
}
