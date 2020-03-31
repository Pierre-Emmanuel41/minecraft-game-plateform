package fr.pederobien.minecraftgameplateform.interfaces.dictionary;

import org.bukkit.entity.Player;

public interface IMessageEvent extends IMessageCodeEvent {

	/**
	 * @return The player to send the message.
	 */
	Player getPlayer();
}
