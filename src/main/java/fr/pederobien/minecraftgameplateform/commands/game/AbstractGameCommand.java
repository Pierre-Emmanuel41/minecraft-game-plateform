package fr.pederobien.minecraftgameplateform.commands.game;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.AbstractCommand;
import fr.pederobien.minecraftgameplateform.dictionary.messages.EMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;
import fr.pederobien.minecraftgameplateform.utils.EventFactory;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public abstract class AbstractGameCommand extends AbstractCommand {

	protected AbstractGameCommand(JavaPlugin plugin, String label) {
		super(plugin, label);
		getPlugin().getCommand(getLabel()).setExecutor(this);
	}

	protected abstract boolean onGameCommand(CommandSender sender, Command command, String label, String[] args);

	@Override
	public final boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (getGameConfigurationContext().getGameConfiguration() == null)
			sendMessageToSender(sender, getPlugin(), EMessageCode.NO_CONFIGURATION_SETTED, args);
		else
			onGameCommand(sender, command, label, args);
		return false;
	}

	/**
	 * Send a message to the given player. First create an {@link IMessageEvent} that is used to get messages into registered
	 * dictionaries for the given Plugin.
	 * 
	 * @param player The player to send a message.
	 * @param plugin The plugin into the message is associated.
	 * @param code   The code used to get the translation of the message in the player's language.
	 * @param args   Arguments that could be useful to send dynamic messages.
	 * 
	 * @return The created message event.
	 */
	protected void sendMessageToSender(CommandSender sender, Plugin plugin, IMessageCode code, String... args) {
		if (sender instanceof Player)
			Plateform.getNotificationCenter().sendMessage(EventFactory.messageEvent((Player) sender, plugin, code, args));
	}

	/**
	 * Send a message to the given player. First create an {@link IMessageEvent} that is used to get messages into registered
	 * dictionaries for the given Plugin.
	 * 
	 * @param player The player to send a message.
	 * @param plugin The plugin into the message is associated.
	 * @param code   The code used to get the translation of the message in the player's language.
	 * @param args   Arguments that could be useful to send dynamic messages.
	 * 
	 * @return The created message event.
	 */
	protected void sendMessage(Player player, Plugin plugin, IMessageCode code, String... args) {
		Plateform.getNotificationCenter().sendMessage(EventFactory.messageEvent(player, plugin, code, args));
	}
}
