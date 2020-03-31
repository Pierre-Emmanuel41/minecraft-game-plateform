package fr.pederobien.minecraftgameplateform.interfaces.dictionary;

import org.bukkit.command.CommandSender;

public interface IMessageEvent extends IMessageCodeEvent {

	/**
	 * @return The sender of the command.
	 */
	CommandSender getSender();
}
