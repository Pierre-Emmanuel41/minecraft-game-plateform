package fr.pederobien.minecraftgameplateform.interfaces.dictionary;

import org.bukkit.plugin.Plugin;

public interface IDictionaryManager {

	/**
	 * Register the given dictionary for the given plugin.
	 * 
	 * @param plugin     The plugin used as key to get the dictionary.
	 * @param dictionary The dictionary used to get message when an {@link IMessageCodeEvent} arrives.
	 * 
	 * @return This dictionary manager to register dictionaries easier.
	 */
	IDictionaryManager register(Plugin plugin, IDictionary dictionary);

	/**
	 * Get the message associated to the message code in the event.
	 * 
	 * @param event The used to get a message stored in a dictionary.
	 * @return The message associated to the message code.
	 * 
	 * @see IMessageCode
	 * @see IDictionary
	 */
	String getMessage(IMessageEvent event);

	/**
	 * Unregister the given dictionary for the given plugin.
	 * 
	 * @param plugin     The plugin used as key to find and remove the dictionary.
	 * @param dictionary The dictionary to remove.
	 * 
	 * @return This dictionary manager to unregister dictionaries easier.
	 */
	IDictionaryManager unregister(Plugin plugin, IDictionary dictionary);
}
