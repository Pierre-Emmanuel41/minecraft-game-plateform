package fr.pederobien.minecraftgameplateform.impl.editions;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftdevelopmenttoolkit.impl.AbstractGenericMapEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionaryManager;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageEvent;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.INotificationCenter;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;
import fr.pederobien.minecraftgameplateform.utils.EventFactory;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public abstract class AbstractMapPersistenceEdition<T extends IUnmodifiableNominable>
		extends AbstractGenericMapEdition<IMessageCode, T, IParentPersistenceEdition<T>, IMapPersistenceEdition<T>> implements IMapPersistenceEdition<T> {

	protected AbstractMapPersistenceEdition(String label, IMessageCode explanation) {
		super(label, explanation);
	}

	@Override
	public final IMapPersistenceEdition<T> setAvailable(boolean available) {
		internalSetAvailable(available);
		return this;
	}

	@Override
	public final IMapPersistenceEdition<T> setModifiable(boolean modifiable) {
		internalSetModifiable(modifiable);
		return this;
	}

	@Override
	public final IMapPersistenceEdition<T> addEdition(IMapPersistenceEdition<T> elt) {
		internalAdd(elt);
		return this;
	}

	@Override
	public final IMapPersistenceEdition<T> removeEdition(IMapPersistenceEdition<T> elt) {
		internalRemove(elt);
		return this;
	}

	/**
	 * Get the persistence coming from the parent of this edition. It is equivalent to call {@link #getParent()} and then
	 * {@link IParentPersistenceEdition#getPersistence()}.
	 * 
	 * @return The persistence used to save/load objects associated to the type <code>T</code>.
	 */
	protected IPersistence<T> getPersistence() {
		return getParent().getPersistence();
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
	protected void sendMessageToSender(CommandSender sender, IMessageCode code, Object... args) {
		if (sender instanceof Player)
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
	protected String getMessageFromDictionary(CommandSender sender, IMessageCode code, Object... args) {
		return sender instanceof Player ? getMessage((Player) sender, code, args) : "";
	}

	/**
	 * Parses the string argument as a signed decimal integer. The characters in the string must all be decimal digits, except that
	 * the first character may be an ASCII minus sign {@code '-'} ({@code '\u005Cu002D'}) to indicate a negative value or an ASCII
	 * plus sign {@code '+'} ({@code '\u005Cu002B'}) to indicate a positive value. The resulting integer value is returned, exactly as
	 * if the argument and the radix 10 were given as arguments to the {@link #parseInt(java.lang.String, int)} method.
	 *
	 * @param number a {@code String} containing the {@code int} representation to be parsed
	 * @return True if the given string contains a parsable integer OR is empty, false otherwise.
	 */
	protected boolean isInt(String number) {
		try {
			if (number.equals(""))
				return true;
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * Parses the string argument as a {@link LocalTime}.
	 * <p>
	 * The string must represent a valid time and is parsed using {@link java.time.format.DateTimeFormatter#ISO_LOCAL_TIME}.
	 *
	 * @param text the text to parse such as "10:15:30", not null.
	 * @return True if the given string contains a parsable time, false otherwise.
	 */
	protected boolean isTime(String time) {
		try {
			LocalTime.parse(time);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	/**
	 * Parses the string argument as a {@link LocalTime}.
	 * <p>
	 * The text is parsed using the formatter, returning a time.
	 *
	 * @param time      the text to parse, not null.
	 * @param formatter the formatter to use, not null.
	 * @return True if the given string contains a parsable time, false otherwise.
	 */
	protected boolean isTime(String time, DateTimeFormatter formatter) {
		try {
			LocalTime.parse(time, formatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

	/**
	 * Parses the string argument as a signed decimal integer. The characters in the string must all be decimal digits, except that
	 * the first character may be an ASCII minus sign {@code '-'} ({@code '\u005Cu002D'}) to indicate a negative value or an ASCII
	 * plus sign {@code '+'} ({@code '\u005Cu002B'}) to indicate a positive value. The resulting integer value is returned, exactly as
	 * if the argument and the radix 10 were given as arguments to the {@link #parseInt(java.lang.String, int)} method.
	 *
	 * @param s a {@code String} containing the {@code int} representation to be parsed.
	 * 
	 * @return the integer value represented by the argument in decimal.
	 * 
	 * @exception NumberFormatException if the string does not contain a parsable integer.
	 */
	protected int getInt(String number) {
		return Integer.parseInt(number);
	}

	/**
	 * Verify the given string start with the specified beginning ignoring case. For example : <br>
	 * <code>str = "IBeGinLIkeThis";<br>
	 * beginning = "ibEginli";<br></code> The method return true.
	 * 
	 * @param str       The string to check.
	 * @param beginning The beginning used as reference.
	 * @return True if the string begin with the given beginning, false otherwise.
	 */
	protected boolean startWithIgnoreCase(String str, String beginning) {
		return str.length() < beginning.length() ? false : str.substring(0, beginning.length()).equalsIgnoreCase(beginning);
	}

	/**
	 * Find all descendants of the parent whose label match on the given label and set their availability to true.
	 * 
	 * @param label The name of the label to match on.
	 * 
	 * @see IParentPersistenceEdition#getChildrenByLabelName(String)
	 * @see #setAvailable(boolean)
	 */
	protected void setNewEditionAvailable(String label) {
		List<IMapPersistenceEdition<T>> descendants = getParent().getChildrenByLabelName(label);
		for (IMapPersistenceEdition<T> descendant : descendants)
			descendant.setAvailable(true);
	}

	/**
	 * Find all descendants of the parent for each label in the given array and set their availability to true.
	 * 
	 * @param labels An array to find different parent's descendants.
	 * 
	 * @see AbstractMapPersistenceEdition#setNewEditionAvailable(String)
	 */
	protected void setNewEditionsAvailable(String... labels) {
		for (String label : labels)
			setNewEditionAvailable(label);
	}

	/**
	 * @return The notification center to send message to player(s) that are currently logged into the server.
	 */
	private INotificationCenter getNotificationCenter() {
		return Plateform.getNotificationCenter();
	}

	private IMessageEvent messageEvent(Player player, IMessageCode code, Object... args) {
		String[] internalArgs = new String[args.length];
		for (int i = 0; i < args.length; i++)
			internalArgs[i] = args[i].toString();
		return EventFactory.messageEvent(player, getParent().getPlugin(), code, internalArgs);
	}

	private String getMessage(Player player, IMessageCode code, Object... args) {
		return ((IDictionaryManager) getNotificationCenter().getDictionaryContext()).getMessage(messageEvent(player, code, args));
	}
}
