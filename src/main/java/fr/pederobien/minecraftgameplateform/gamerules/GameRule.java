package fr.pederobien.minecraftgameplateform.gamerules;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftdictionary.impl.MinecraftMessageEvent;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageEvent;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;
import fr.pederobien.minecraftgameplateform.impl.element.AbstractNominable;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameRule;
import fr.pederobien.minecraftgameplateform.interfaces.element.IRunnableGameRule;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.WorldManager;

public abstract class GameRule<T> extends AbstractNominable implements IGameRule<T> {
	/**
	 * A list that contains all runnable rules
	 */
	public static final List<IRunnableGameRule<?>> RUNNABLE_RULES = new ArrayList<IRunnableGameRule<?>>();

	public static final List<IGameRule<?>> RULES = new ArrayList<IGameRule<?>>();

	/**
	 * Game rule to enable/deactivate the display of player team mates location.
	 */
	public static final IRunnableGameRule<Boolean> DISPLAY_CURRENT_TEAMMATE_LOCATION = new DisplayCurrentTeammatesLocation();

	/**
	 * Game rule to enable/deactivate the pvp in the overworld, nether and end.
	 */
	public static final IGameRule<Boolean> PVP = new Pvp();

	private T value, defaultValue;
	private Class<T> type;
	private TabCompleter completer;
	private CommandExecutor executor;
	private IMinecraftMessageCode explanation;

	protected GameRule(String name, T defaultValue, Class<T> type, IMinecraftMessageCode explanation) {
		super(name);
		this.defaultValue = defaultValue;
		this.type = type;
		RULES.add(this);
	}

	@Override
	public T getValue() {
		return value == null ? defaultValue : value;
	}

	@Override
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public T getDefaultValue() {
		return defaultValue;
	}

	@Override
	public Class<T> getType() {
		return type;
	}

	@Override
	public IMinecraftMessageCode getExplanation() {
		return explanation;
	}

	@Override
	public TabCompleter getCompleter() {
		return completer;
	}

	@Override
	public CommandExecutor getExecutor() {
		return executor;
	}

	/**
	 * @param completer The completer that propose completions for this command.
	 */
	protected void setCompleter(TabCompleter completer) {
		this.completer = completer;
	}

	/**
	 * @param executor The executor that execute some code.
	 */
	protected void setExecutor(CommandExecutor executor) {
		this.executor = executor;
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries for the given Plugin. This method is synchronized with {@link GameRule#SEND_COMMAND_FEEDBACK}. This means that if
	 * the game rule has been set to false, then no message is send.
	 * 
	 * @param sender Generally a player, it is used to get a message in his language.
	 * @param plugin The plugin into the message is associated.
	 * @param code   The code used to get the translation of the message in the player's language.
	 * @param args   Arguments that could be useful to send dynamic messages.
	 * 
	 * @return The created message event.
	 */
	protected void sendMessageToSender(CommandSender sender, IMinecraftMessageCode code, Object... args) {
		if (sender instanceof Player && WorldManager.OVERWORLD.getGameRuleValue(org.bukkit.GameRule.SEND_COMMAND_FEEDBACK))
			getNotificationCenter().sendMessage(messageEvent((Player) sender, code, args));
	}

	/**
	 * Send a message to the given player. First create an {@link IMinecraftMessageEvent} that is used to get messages into registered
	 * dictionaries for the given Plugin. This method send a message even if the game rule {@link GameRule#SEND_COMMAND_FEEDBACK} is
	 * set to false.
	 * 
	 * @param sender Generally a player, it is used to get a message in his language.
	 * @param plugin The plugin into the message is associated.
	 * @param code   The code used to get the translation of the message in the player's language.
	 * @param args   Arguments that could be useful to send dynamic messages.
	 * 
	 * @return The created message event.
	 * 
	 * @see #sendMessageToSender(CommandSender, IMinecraftMessageCode, Object...)
	 */
	protected void sendMessageToSenderNotSynchonized(CommandSender sender, IMinecraftMessageCode code, Object... args) {
		if (sender instanceof Player && WorldManager.OVERWORLD.getGameRuleValue(org.bukkit.GameRule.SEND_COMMAND_FEEDBACK))
			getNotificationCenter().sendMessage(messageEvent((Player) sender, code, args));
	}

	/**
	 * Get a message corresponding to the given message code.
	 * 
	 * @param sender Generally a player, it is used to get a message in his language.
	 * @param code   The code used to get the translation of the message in the player's language.
	 * @param args   Arguments that could be useful to send dynamic messages.
	 * 
	 * @return The message associated to the specified code. If the sender is not a player, then it returns an empty string.
	 */
	protected String getMessageFromDictionary(CommandSender sender, IMinecraftMessageCode code, Object... args) {
		return sender instanceof Player ? getMessage((Player) sender, code, args) : "";
	}

	private IMinecraftNotificationCenter getNotificationCenter() {
		return Plateform.getNotificationCenter();
	}

	private IMinecraftMessageEvent messageEvent(Player player, IMinecraftMessageCode code, Object... args) {
		String[] internalArgs = new String[args.length];
		for (int i = 0; i < args.length; i++)
			internalArgs[i] = args[i].toString();
		return new MinecraftMessageEvent(player, code, (Object[]) internalArgs);
	}

	private String getMessage(Player player, IMinecraftMessageCode code, Object... args) {
		return getNotificationCenter().getDictionaryContext().getMessage(messageEvent(player, code, args));
	}

	static {
		RUNNABLE_RULES.add(DISPLAY_CURRENT_TEAMMATE_LOCATION);
	}
}
