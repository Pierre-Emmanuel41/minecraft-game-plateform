package fr.pederobien.minecraftgameplateform.exceptions.dictionary;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionary;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class AbstractDictionaryMessageException extends AbstractDictionaryException {
	private static final long serialVersionUID = 1L;
	private IDictionary dictionary;

	protected AbstractDictionaryMessageException(IMessageEvent event, IDictionary dictionary) {
		super(event);
		this.dictionary = dictionary;
	}

	/**
	 * @return The dictionary in which the messages is registered.
	 */
	public IDictionary getDictionary() {
		return dictionary;
	}

}
