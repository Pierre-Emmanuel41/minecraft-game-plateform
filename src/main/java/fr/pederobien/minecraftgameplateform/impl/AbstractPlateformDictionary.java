package fr.pederobien.minecraftgameplateform.impl;

import java.util.Locale;

import fr.pederobien.minecraftdictionary.impl.AbstractDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.interfaces.element.IMessages;

public class AbstractPlateformDictionary extends AbstractDictionary {

	protected AbstractPlateformDictionary(Locale... locales) {
		super(locales);
	}

	protected void register(IMessages... list) {
		for (IMessages messages : list)
			for (IMessage message : messages.getMessages())
				register(message);
	}
}
