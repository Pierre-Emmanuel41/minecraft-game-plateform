package fr.pederobien.minecraft.gameplateform.impl.editions;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraft.gameplateform.commands.configurations.GameConfigurationEditionFactory;
import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.gameplateform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public abstract class AbstractGameConfigurationParent<T extends IGameConfiguration> extends AbstractConfigurationParentPersistenceEdition<T> {

	public AbstractGameConfigurationParent(String label, IMinecraftMessageCode explanation, Plugin plugin, IMinecraftPersistence<T> persistence) {
		super(label, explanation, plugin, persistence);

		addEdition(GameConfigurationEditionFactory.asCurrentEdition());
		addEdition(GameConfigurationEditionFactory.teamEdition());
		addEdition(GameConfigurationEditionFactory.pvpTime());
	}
}
