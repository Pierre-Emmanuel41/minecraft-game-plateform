package fr.pederobien.minecraftgameplateform.commands.game;

import java.util.stream.Stream;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftdictionary.impl.MinecraftMessageEvent;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageEvent;
import fr.pederobien.minecraftgameplateform.commands.AbstractCommand;
import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;
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
			sendMessageToSender(sender, EGameMessageCode.NO_CONFIGURATION_SETTED, args);
		else
			onGameCommand(sender, command, label, args);
		return false;
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries for the given Plugin.
	 * 
	 * @param player The player to send a message.
	 * @param code   The code used to get the translation of the message in the player's language.
	 * @param args   Arguments that could be useful to send dynamic messages.
	 * 
	 * @return The created message event.
	 */
	protected void sendMessageToSender(CommandSender sender, IMinecraftMessageCode code, String... args) {
		if (sender instanceof Player)
			sendMessage((Player) sender, code, args);
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries for the given Plugin.
	 * 
	 * @param player The player to send a message.
	 * @param code   The code used to get the translation of the message in the player's language.
	 * @param args   Arguments that could be useful to send dynamic messages.
	 */
	protected void sendMessage(Player player, IMinecraftMessageCode code, String... args) {
		Plateform.getNotificationCenter().sendMessage(new MinecraftMessageEvent(player, code, (Object[]) args));
	}

	/**
	 * Send a message associated to the given message code to each player in the specified stream.
	 * 
	 * @param players A stream that contains all players to send a message.
	 * @param code    The code used to get the translation of the message in the player's language.
	 * @param args    Arguments that could be useful to send dynamic messages.
	 */
	protected void sendMessageToPlayers(Stream<Player> players, IMinecraftMessageCode code, String... args) {
		players.peek(player -> sendMessage(player, code, args));
	}
}
