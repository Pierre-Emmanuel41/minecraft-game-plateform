package fr.pederobien.minecraftgameplateform.dictionary;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.exceptions.dictionary.DictionaryNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.dictionary.MessageNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.dictionary.NoRegisteredDictionaryException;
import fr.pederobien.minecraftgameplateform.exceptions.dictionary.SecondTryMessageNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionary;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionaryManager;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class DictionaryManager implements IDictionaryManager {
	private Map<Plugin, Map<Locale, IDictionary>> dictionaries;

	public DictionaryManager() {
		dictionaries = new HashMap<Plugin, Map<Locale, IDictionary>>();
	}

	@Override
	public IDictionaryManager register(Plugin plugin, IDictionary dictionary) {
		Map<Locale, IDictionary> intermediate = dictionaries.get(plugin);

		// First dictionary registration for this plugin
		if (intermediate == null)
			intermediate = new HashMap<Locale, IDictionary>();

		// Register the dictionary for all supported locales.
		for (Locale locale : dictionary.getLocales())
			intermediate.put(locale, dictionary);

		dictionaries.put(plugin, intermediate);
		return this;
	}

	@Override
	public String getMessage(IMessageEvent event) {
		Map<Locale, IDictionary> intermediate = dictionaries.get(event.getPlugin());

		// When there is not dictionary registered for this plugin
		if (intermediate == null)
			throw new NoRegisteredDictionaryException(event);

		Locale locale = Locale.forLanguageTag(event.getPlayer().getLocale().replace('_', '-'));

		// When the locale is not recognised by class Locale (should never happen)
		if (locale == null)
			locale = Locale.ENGLISH;

		// Dictionary that contains message in the player's language
		IDictionary firstDictionary = null;
		try {
			firstDictionary = getDictionary(intermediate, event, locale);
			return firstDictionary.getMessage(event);
		} catch (MessageNotFoundException | DictionaryNotFoundException e) {

			// Dictionary that contains messages in English
			IDictionary secondDictionary = getDictionary(intermediate, event, Locale.ENGLISH);
			try {
				return secondDictionary.getMessage(event);
			} catch (MessageNotFoundException e1) {
				throw new SecondTryMessageNotFoundException(event, firstDictionary, secondDictionary, locale, Locale.ENGLISH);
			}
		}
	}

	@Override
	public IDictionaryManager unregister(Plugin plugin, IDictionary dictionary) {
		Map<Locale, IDictionary> intermediate = dictionaries.get(plugin);

		// When there is no dictionary registered for the given plugin.
		if (intermediate == null)
			return this;

		// Unregister the dictionary for each supported locales.
		for (Locale locale : dictionary.getLocales())
			intermediate.remove(locale, dictionary);
		return this;
	}

	private IDictionary getDictionary(Map<Locale, IDictionary> dictionaries, IMessageEvent event, Locale locale) {
		IDictionary dictionary = dictionaries.get(locale);
		if (dictionary == null)
			throw new DictionaryNotFoundException(event, locale);
		return dictionary;
	}
}
