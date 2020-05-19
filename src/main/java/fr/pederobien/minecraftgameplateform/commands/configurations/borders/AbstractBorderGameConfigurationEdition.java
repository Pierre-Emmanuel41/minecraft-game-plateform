package fr.pederobien.minecraftgameplateform.commands.configurations.borders;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.border.persistence.BorderPersistence;
import fr.pederobien.minecraftgameplateform.commands.configurations.AbstractGameConfigurationEdition;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.BorderConfigurationNotRegisteredException;
import fr.pederobien.minecraftgameplateform.exceptions.configurations.ConfigurationNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;
import fr.pederobien.persistence.interfaces.IPersistence;

public class AbstractBorderGameConfigurationEdition<T extends IGameBorderConfiguration> extends AbstractGameConfigurationEdition<T> {
	public static final IPersistence<IBorderConfiguration> PERSISTENCE = BorderPersistence.getInstance();

	protected AbstractBorderGameConfigurationEdition(ILabel label, IMinecraftMessageCode explanation) {
		super(label, explanation);
	}

	/**
	 * Remove configurations already mentioned from the list returned by {@link IPersistence#list()}. The persistence is an instance
	 * of {@link BorderPersistence}.
	 * 
	 * @param alreadyMentionnedConfigurations A list that contains already mentioned configurations.
	 * @return A stream that contains free and not mentioned configurations.
	 */
	protected Stream<String> getFreeBorderConfigurations(List<String> alreadyMentionnedConfigurations) {
		return PERSISTENCE.list().stream().filter(conf -> !alreadyMentionnedConfigurations.contains(conf) && !get().getConfiguration(conf).isPresent());
	}

	/**
	 * Load the configuration for each name in the array <code>args</code>.
	 * 
	 * @param args An array that contains each configuration to load.
	 * 
	 * @return A list of loaded configuration.
	 * 
	 * @throws ConfigurationNotFoundException If the configuration file associated to a name does not exist.
	 */
	protected List<IBorderConfiguration> getConfigurations(String... args) {
		List<IBorderConfiguration> configurations = new ArrayList<IBorderConfiguration>();
		String current = "";
		try {
			for (String name : args) {
				current = name;
				PERSISTENCE.load(name);
			}
			configurations.add(PERSISTENCE.get());
		} catch (FileNotFoundException e) {
			throw new ConfigurationNotFoundException(current);
		}
		return configurations;
	}

	/**
	 * Get the border configuration in the game configuration associated to each name present in the given array <code>args</code>.
	 * 
	 * @param args The array that contains the border configuration name to get from the game configuration.
	 * @return A list that contains registered border configurations.
	 * 
	 * @throws BorderConfigurationNotRegisteredException If there is any registered configuration for a name.
	 * @see #get()
	 */
	protected List<IBorderConfiguration> getConfigurationsFromGameConfiguration(String... args) {
		List<IBorderConfiguration> configurations = new ArrayList<IBorderConfiguration>();
		for (String name : args) {
			Optional<IBorderConfiguration> optConf = get().getConfiguration(name);
			if (!optConf.isPresent())
				throw new BorderConfigurationNotRegisteredException(get(), name);
			configurations.add(optConf.get());
		}
		return configurations;
	}
}
