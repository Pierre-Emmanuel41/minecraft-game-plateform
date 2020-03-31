package fr.pederobien.minecraftgameplateform.interfaces.dictionary;

import java.util.List;
import java.util.Locale;

public interface IDictionary {

	/**
	 * @return All locales supported by this dictionary. All locales should correspond to the same language. For instance :
	 *         {@link Locale#ENGLISH}, {@link Locale#UK} etc... This list is unmodifiable.
	 */
	List<Locale> getLocales();

	/**
	 * Get the message associated to the message code from the message code event.
	 * 
	 * @param event The event used to get the message.
	 * 
	 * @return The associated message.
	 */
	String getMessage(IMessageEvent event);

	/**
	 * Register the given message to this dictionary.
	 * 
	 * @param message The message to store.
	 * 
	 * @return This dictionary to register messages easier.
	 */
	IDictionary register(IMessage message);
}
