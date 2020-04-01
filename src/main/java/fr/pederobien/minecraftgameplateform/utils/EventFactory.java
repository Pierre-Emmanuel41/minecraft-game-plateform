package fr.pederobien.minecraftgameplateform.utils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.dictionary.MessageEvent;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;

public class EventFactory {

	/**
	 * Create a message code event. This event is used to get messages into registered dictionaries for the given Plugin.
	 * 
	 * @param player The player to send a message.
	 * @param plugin The plugin into the message is associated.
	 * @param code   The code used to get the translation of the message in the player's language.
	 * @param args   Arguments that could be useful to send dynamic messages.
	 * 
	 * @return The created message event.
	 */
	public static IMessageEvent messageEvent(Player player, Plugin plugin, IMessageCode code, String... args) {
		return new MessageEvent(player, plugin, code, args);
	}
}
