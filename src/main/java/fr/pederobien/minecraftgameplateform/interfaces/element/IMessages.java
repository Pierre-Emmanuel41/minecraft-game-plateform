package fr.pederobien.minecraftgameplateform.interfaces.element;

import java.util.List;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
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

	/**
	 * Set the dictionary to which this messages is associated. When a message is added, it is also added to the given dictionary
	 * 
	 * @param dictionary The dictionary associated to this messages.
	 */
	void setDictionary(IDictionary dictionary);
}
