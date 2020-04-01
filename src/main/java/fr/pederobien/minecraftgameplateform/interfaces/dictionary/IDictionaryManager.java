package fr.pederobien.minecraftgameplateform.interfaces.dictionary;

import fr.pederobien.minecraftgameplateform.dictionary.IDictionaryContext;

public interface IDictionaryManager extends IDictionaryContext {

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
}
