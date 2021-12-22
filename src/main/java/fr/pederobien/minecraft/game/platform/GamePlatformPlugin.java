package fr.pederobien.minecraft.game.platform;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.dictionary.impl.JarXmlDictionaryParser;
import fr.pederobien.minecraft.dictionary.impl.MinecraftDictionaryContext;

public class GamePlatformPlugin extends JavaPlugin {
	private static final Path DICTIONARY_FOLDER = Paths.get("resources/dictionaries");

	private static Plugin instance;

	/**
	 * @return The plugin associated to this plateform plugin.
	 */
	public static Plugin instance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;

		registerDictionaries();
	}

	@Override
	public void onDisable() {
		Platform.getPersistenceCenter().save();
	}

	private void registerDictionaries() {
		try {
			JarXmlDictionaryParser dictionaryParser = new JarXmlDictionaryParser(getFile().toPath());

			MinecraftDictionaryContext context = MinecraftDictionaryContext.instance();
			String[] dictionaries = new String[] { "English.xml", "French.xml" };
			for (String dictionary : dictionaries)
				context.register(dictionaryParser.parse(DICTIONARY_FOLDER.resolve(dictionary)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
