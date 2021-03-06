package fr.pederobien.minecraftgameplateform;

import java.io.FileNotFoundException;
import java.nio.file.Path;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.dictionary.interfaces.IDictionaryParser;
import fr.pederobien.minecraftgameplateform.commands.game.PauseCommand;
import fr.pederobien.minecraftgameplateform.commands.game.StartCommand;
import fr.pederobien.minecraftgameplateform.commands.game.StopCommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class PlateformPlugin extends JavaPlugin {
	private static Plugin plugin;

	/**
	 * @return The plugin associated to this plateform plugin.
	 */
	public static Plugin get() {
		return plugin;
	}

	@Override
	public void onEnable() {
		new Platform(this);
		plugin = this;

		new StartCommand(this);
		new PauseCommand(this);
		new StopCommand(this);

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
