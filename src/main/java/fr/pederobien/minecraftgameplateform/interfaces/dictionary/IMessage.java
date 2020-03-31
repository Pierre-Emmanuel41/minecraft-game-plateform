package fr.pederobien.minecraftgameplateform.interfaces.dictionary;

public interface IMessage {

	/**
	 * @return The code associated to this message.
	 */
	IMessageCode getCode();

	/**
	 * Get the message associated to the code returned by {@link #getCode()}. Some messages need to be dynamic. This method is used to
	 * get more information for this message.
	 * 
	 * @param args An array used to send dynamic message.
	 * 
	 * @return The message associated to the key.
	 */
	String getMessage(String... args);
}
