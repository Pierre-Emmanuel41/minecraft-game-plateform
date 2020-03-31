package fr.pederobien.minecraftgameplateform.interfaces.dictionary;

import fr.pederobien.minecraftgameplateform.dictionary.Permission;

public interface IMessageCode {

	/**
	 * @return The permission used to send the message.
	 */
	Permission getPermission();

	/**
	 * Set the new permission of this message code.
	 * 
	 * @param permission The new permission of this message.
	 */
	void setPermission(Permission permission);
}
