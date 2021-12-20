package fr.pederobien.minecraft.game.platform;

import java.io.FileNotFoundException;
import java.nio.file.Path;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.dictionary.interfaces.IDictionaryParser;
import fr.pederobien.minecraft.game.platform.utils.Plateform;

public class GamePlatformPlugin extends JavaPlugin {
	private static Plugin instance;

	/**
	 * @return The plugin associated to this plateform plugin.
	 */
	public static Plugin instance() {
		return instance;
	}

	@Override
	public void onEnable() {
		new Platform(this);
		instance = this;

		registerDictionaries();
	}

	@Override
	public void onDisable() {
		Plateform.getPersistenceCenter().save();
	}

	private void registerDictionaries() {
		String[] dictionaries = new String[] { "Common.xml", "Game.xml", "WorldStructure.xml", "Configurations.xml", "Entry.xml", "Plateform.xml" };
		// Registering French dictionaries
		registerDictionary("French", dictionaries);

		// Registering English dictionaries
		registerDictionary("English", dictionaries);
	}

	private void registerDictionary(String parent, String... dictionaryNames) {
		Path jarPath = Plateform.ROOT.getParent().resolve(getName().concat(".jar"));
		String dictionariesFolder = "resources/dictionaries/".concat(parent).concat("/");
		for (String name : dictionaryNames)
			registerDictionary(Plateform.getDefaultDictionaryParser(dictionariesFolder.concat(name)), jarPath);
	}

	private void registerDictionary(IDictionaryParser parser, Path jarPath) {
		try {
			Plateform.getNotificationCenter().getDictionaryContext().register(parser, jarPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private class Platform extends Plateform {

		protected Platform(Plugin plugin) {
			setPlugin(plugin);
		}
	}
}
