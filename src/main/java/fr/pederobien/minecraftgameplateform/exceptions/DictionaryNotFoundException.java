package fr.pederobien.minecraftgameplateform.exceptions;

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
	public String getMessage() {
		StringJoiner joiner = new StringJoiner(", ");
		joiner.add("No Dictionary found");
		joiner.add(super.getMessage());
		return joiner.add("{Locale=" + getLocale().toString() + "}").toString();
	}
}
