package fr.pederobien.minecraftgameplateform.exceptions.dictionary;

import java.util.Locale;
import java.util.StringJoiner;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class DictionaryNotFoundException extends AbstractDictionaryException {
	private static final long serialVersionUID = 1L;
	private Locale locale;

	public DictionaryNotFoundException(IMessageEvent event, Locale locale) {
		super(event);
		this.locale = locale;
	}

	/**
	 * @return The locale used as key to find the dictionary.
	 */
	public Locale getLocale() {
		return locale;
	}

	@Override
	public StringJoiner getInternalMessage(StringJoiner joiner) {
		joiner.add("No Dictionary found");
		super.getInternalMessage(joiner);
		return joiner.add("{Locale=" + getLocale().toString() + "}");
	}
}
