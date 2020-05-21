package fr.pederobien.minecraftgameplateform.commands.game;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
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
import fr.pederobien.minecraftgameplateform.interfaces.commands.IParentCommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

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

	/**
	 * @return The list of all registered commands.
	 */
	protected List<IParentCommand<IUnmodifiableNominable>> getCommands() {
		return Plateform.getCommandHelper().getCommands();
	}

	/**
	 * Notify each command registered in the list <code>commands</code> using the given consumer.
	 * 
	 * @param commands A list of commands to notify.
	 * @param consumer The consumer used to notify commands.
	 */
	protected void notifyCommands(List<IParentCommand<IUnmodifiableNominable>> commands, Consumer<IParentCommand<IUnmodifiableNominable>> consumer) {
		for (IParentCommand<IUnmodifiableNominable> command : commands)
			consumer.accept(command);
	}

	/**
	 * Notify each command registered in the list <code>commands</code> using the given predicate.
	 * 
	 * @param commands  A list of commands to notify.
	 * @param predicate The predicate used to notify commands.
	 * @param result    A boolean that represent the result of the notification.
	 * @return A boolean that correspond to the global result of each command notification.
	 */
	protected boolean notifyCommands(List<IParentCommand<IUnmodifiableNominable>> commands, Predicate<IParentCommand<IUnmodifiableNominable>> predicate, boolean result) {
		for (IParentCommand<IUnmodifiableNominable> command : commands)
			result &= predicate.test(command);
		return result;
	}
}
