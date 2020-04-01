package fr.pederobien.minecraftgameplateform.dictionary;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.exceptions.dictionary.DictionaryNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.dictionary.MessageNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.dictionary.NoRegisteredDictionaryException;
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
		return this;
	}

	@Override
	public String getMessage(IMessageEvent event) {
		Locale locale = Locale.forLanguageTag(event.getPlayer().getLocale().replace('_', '-'));
		Map<Locale, IDictionary> intermediate = dictionaries.get(event.getPlugin());

		// When there is not dictionary registered for this plugin
		if (intermediate == null)
			throw new NoRegisteredDictionaryException(event);

		try {
			return getDictionary(intermediate, event, locale).getMessage(event);
		} catch (MessageNotFoundException e) {
			return getDictionary(intermediate, event, Locale.ENGLISH).getMessage(event);
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
