package fr.pederobien.minecraftgameplateform.exceptions.dictionary;

import java.util.Locale;
import java.util.StringJoiner;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionary;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class SecondTryMessageNotFoundException extends AbstractDictionaryMessageException {
	private static final long serialVersionUID = 1L;
	private IDictionary secondDictionary;
	private Locale firstLocale, secondLocale;

	public SecondTryMessageNotFoundException(IMessageEvent event, IDictionary dictionary, IDictionary secondDictionary, Locale firstLocale, Locale secondLocale) {
		super(event, dictionary);
		this.secondDictionary = secondDictionary;
		this.firstLocale = firstLocale;
		this.secondLocale = secondLocale;
	}

	/**
	 * @return The second dictionary used to find the message. This dictionary could be null if it was not found.
	 */
	public IDictionary getSecondDictionary() {
		return secondDictionary;
	}

	/**
	 * @return The player locale used to find a message translated in its language.
	 */
	public Locale getFirstLocale() {
		return firstLocale;
	}

	/**
	 * @return Generally equals to {@link Locale#ENGLISH}, this locale is used when no message has been found in the dictionary that
	 *         contains messages in the player language.
	 */
	public Locale getSecondLocale() {
		return secondLocale;
	}

	@Override
	public StringJoiner getInternalMessage(StringJoiner joiner) {
		return super.getInternalMessage(joiner);
	}
}
