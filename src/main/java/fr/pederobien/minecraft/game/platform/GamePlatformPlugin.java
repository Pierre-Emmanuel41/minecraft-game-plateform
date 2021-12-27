package fr.pederobien.minecraft.game.platform;

import java.io.FileNotFoundException;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.dictionary.exceptions.MessageRegisteredException;
import fr.pederobien.dictionary.impl.JarXmlDictionaryParser;
import fr.pederobien.minecraft.dictionary.impl.MinecraftDictionaryContext;
import fr.pederobien.minecraft.game.event.GameStartPostEvent;
import fr.pederobien.utils.AsyncConsole;
import fr.pederobien.utils.event.EventHandler;
import fr.pederobien.utils.event.EventManager;
import fr.pederobien.utils.event.IEventListener;

public class GamePlatformPlugin extends JavaPlugin implements IEventListener {
	private static final String DICTIONARY_FOLDER = "resources/dictionaries/";

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

		EventManager.registerListener(this);

		registerDictionaries();
	}

	private void registerDictionaries() {
		try {
			JarXmlDictionaryParser dictionaryParser = new JarXmlDictionaryParser(getFile().toPath());

			MinecraftDictionaryContext context = MinecraftDictionaryContext.instance();
			String[] dictionaries = new String[] { "English.xml", "French.xml" };
			for (String dictionary : dictionaries)
				try {
					context.register(dictionaryParser.parse(DICTIONARY_FOLDER.concat(dictionary)));
				} catch (MessageRegisteredException e) {
					AsyncConsole.print(e);
					for (StackTraceElement element : e.getStackTrace())
						AsyncConsole.print(element);
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@EventHandler
	private void onGameStart(GameStartPostEvent event) {
		Platform.register(event.getGame().getPlugin());
	}

	@EventHandler
	private void onGameStop(GameStartPostEvent event) {
		Platform.unregister(event.getGame().getPlugin());
	}
}
