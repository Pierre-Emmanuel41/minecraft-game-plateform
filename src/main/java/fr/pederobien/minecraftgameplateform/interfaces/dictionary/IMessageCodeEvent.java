package fr.pederobien.minecraftgameplateform.interfaces.dictionary;

import org.bukkit.plugin.Plugin;

public interface IMessageCodeEvent {

	/**
	 * @return The plugin to which the message code is associated.
	 */
	Plugin getPlugin();

	/**
	 * @return The code used to get the associated {@link IMessage}.
	 */
	IMessageCode getCode();

	/**
	 * @return An array of arguments used for {@link IMessage#getMessage(String...)}.
	 */
	String[] getArgs();
}
