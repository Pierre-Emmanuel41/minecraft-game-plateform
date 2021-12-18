package fr.pederobien.minecraft.gameplateform.interfaces.element;

import java.util.List;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public interface IMessages {

	/**
	 * Append the given message to this list.
	 * 
	 * @param message The message to add.
	 */
	void add(IMinecraftMessage message);

	/**
	 * @return The list of registered messages. This list is unmodifiable.
	 */
	List<IMinecraftMessage> getMessages();

	/**
	 * Set the dictionary to which this messages is associated. When a message is added, it is also added to the given dictionary
	 * 
	 * @param dictionary The dictionary associated to this messages.
	 */
	void setDictionary(IDictionary dictionary);
}
