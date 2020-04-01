package fr.pederobien.minecraftgameplateform.dictionary;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import fr.pederobien.minecraftgameplateform.exceptions.MessageNotFoundException;
import fr.pederobien.minecraftgameplateform.exceptions.NotEnoughArgumentsException;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionary;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class AbstractDictionary implements IDictionary {
	private List<Locale> locales;
	private Map<IMessageCode, IMessage> messages;
	private List<IMessage> messageValues;

	protected AbstractDictionary(Locale... locales) {
		this.locales = Arrays.asList(locales);
		messages = new HashMap<IMessageCode, IMessage>();
	}

	@Override
	public List<Locale> getLocales() {
		return Collections.unmodifiableList(locales);
	}

	@Override
	public String getMessage(IMessageEvent event) {
		IMessage message = messages.get(event.getCode());
		if (message == null)
			throw new MessageNotFoundException(event, this);

		try {
			return message.getMessage(event.getArgs());
		} catch (IndexOutOfBoundsException e) {
			throw new NotEnoughArgumentsException(event, this);
		}
	}

	@Override
	public IDictionary register(IMessage message) {
		messages.put(message.getCode(), message);
		updateMessageValues();
		return this;
	}

	@Override
	public IDictionary unregister(IMessageCode code) {
		if (messages.remove(code) != null)
			updateMessageValues();
		return this;
	}

	@Override
	public List<IMessage> getMessages() {
		return Collections.unmodifiableList(messageValues);
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(", ");
		for (Locale locale : locales)
			joiner.add(locale.toString());
		return "{Dictionary={languages={" + joiner + "}}}";
	}

	private void updateMessageValues() {
		messageValues = messages.values().stream().collect(Collectors.toList());
	}
}
