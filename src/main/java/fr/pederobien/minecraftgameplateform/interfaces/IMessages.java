package fr.pederobien.minecraftgameplateform.interfaces;

import java.util.List;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public interface IMessages {

	/**
	 * Append the given message to this list.
	 * 
	 * @param message The message to add.
	 */
	void add(IMessage message);

	/**
	 * @return The list of registered messages. This list is unmodifiable.
	 */
	List<IMessage> getMessages();
}
