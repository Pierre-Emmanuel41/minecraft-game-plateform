package fr.pederobien.minecraftgameplateform.interfaces.dictionary;

public interface IMessageCodeEvent {

	/**
	 * @return The code used to get the associated {@link IMessage}.
	 */
	IMessageCode getCode();

	/**
	 * @return An array of arguments used for {@link IMessage#getMessage(String...)}.
	 */
	String[] getArgs();
}
