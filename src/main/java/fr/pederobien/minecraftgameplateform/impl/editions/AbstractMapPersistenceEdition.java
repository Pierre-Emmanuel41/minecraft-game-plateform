package fr.pederobien.minecraftgameplateform.impl.editions;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.StringJoiner;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.pederobien.minecraftdevelopmenttoolkit.impl.messagecode.AbstractMessageCodeMapEdition;
import fr.pederobien.minecraftdictionary.impl.EventFactory;
import fr.pederobien.minecraftdictionary.interfaces.IDictionaryManager;
import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;
import fr.pederobien.minecraftdictionary.interfaces.IMessageEvent;
import fr.pederobien.minecraftdictionary.interfaces.INotificationCenter;
import fr.pederobien.minecraftgameplateform.helpers.DisplayHelper;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public abstract class AbstractMapPersistenceEdition<T extends IUnmodifiableNominable>
		extends AbstractMessageCodeMapEdition<T, IParentPersistenceEdition<T>, IMapPersistenceEdition<T>> implements IMapPersistenceEdition<T> {

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
	 * @param sender Generally a player, it is used to get a message in his language.
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
	protected boolean isNotStrictInt(String number) {
		return number.equals("") || number.equals("-") || isStrictInt(number);
	}

	/**
	 * Parses the string argument as a signed decimal integer. The characters in the string must all be decimal digits, except that
	 * the first character may be an ASCII minus sign {@code '-'} ({@code '\u005Cu002D'}) to indicate a negative value or an ASCII
	 * plus sign {@code '+'} ({@code '\u005Cu002B'}) to indicate a positive value. The resulting integer value is returned, exactly as
	 * if the argument and the radix 10 were given as arguments to the {@link #parseInt(java.lang.String, int)} method.
	 *
	 * @param number a {@code String} containing the {@code int} representation to be parsed
	 * @return True if the given string contains a parsable integer false otherwise.
	 */
	protected boolean isStrictInt(String number) {
		try {
			Integer.parseInt(number);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Parses the string argument as a signed decimal double.
	 *
	 * @param number the string to be parsed.
	 * 
	 * @return True if the given string contains a parsable double OR is empty, false otherwise.
	 * 
	 * @throws NullPointerException  if the string is null.
	 * @throws NumberFormatException if the string does not contain a parsable {@code double}.
	 * 
	 * @see java.lang.Double#valueOf(String)
	 */
	protected boolean isNotStrictDouble(String number) {
		return number.equals("") || number.equals("-") || isStrictDouble(number);
	}

	/**
	 * Parses the string argument as a signed decimal double.
	 *
	 * @param number the string to be parsed.
	 * 
	 * @return True if the given string contains a parsable double false otherwise.
	 * 
	 * @throws NullPointerException  if the string is null.
	 * @throws NumberFormatException if the string does not contain a parsable {@code double}.
	 * 
	 * @see java.lang.Double#valueOf(String)
	 */
	protected boolean isStrictDouble(String number) {
		try {
			Double.parseDouble(number);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Parses the string argument as a {@link LocalTime}.
	 * <p>
	 * The string must represent a valid time and is parsed using {@link java.time.format.DateTimeFormatter#ISO_LOCAL_TIME}.
	 *
	 * @param text the text to parse such as "10:15:30", not null.
	 * @return True if the given string contains a parsable time OR is empty, false otherwise.
	 */
	protected boolean isNotStrictTime(String time) {
		return time.equals("") || isStrictTime(time);
	}

	/**
	 * Parses the string argument as a {@link LocalTime}.
	 * <p>
	 * The string must represent a valid time and is parsed using {@link java.time.format.DateTimeFormatter#ISO_LOCAL_TIME}.
	 *
	 * @param text the text to parse such as "10:15:30", not null.
	 * @return True if the given string contains a parsable time, false otherwise.
	 */
	protected boolean isStrictTime(String time) {
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
	 * @return True if the given string contains a parsable time OR is empty, false otherwise.
	 */
	protected boolean isNotStrictTime(String time, DateTimeFormatter formatter) {
		return time.equals("") || isStrictTime(time, formatter);
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
	protected boolean isStrictTime(String time, DateTimeFormatter formatter) {
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
	protected void setAvailableEdition(String label) {
		getParent().getChildrenByLabelName(label).forEach(descendant -> descendant.setAvailable(true));
	}

	/**
	 * Find all descendants of the parent for each label in the given array and set their availability to true.
	 * 
	 * @param labels An array to find different parent's descendants.
	 * 
	 * @see AbstractMapPersistenceEdition#setAvailableEdition(String)
	 */
	protected void setAvailableEditions(String... labels) {
		for (String label : labels)
			setAvailableEdition(label);
	}

	/**
	 * Find all descendants of the parent whose label match on the given label and set their availability to true.
	 * 
	 * @param label The name of the label to match on.
	 * 
	 * @see IParentPersistenceEdition#getChildrenByLabelName(String)
	 * @see #setAvailable(boolean)
	 */
	protected void setNotAvailableEdition(String label) {
		getParent().getChildrenByLabelName(label).forEach(descendant -> descendant.setModifiable(true).setAvailable(true).setModifiable(false));
	}

	/**
	 * Find all descendants of the parent for each label in the given array and set their availability to true.
	 * 
	 * @param labels An array to find different parent's descendants.
	 * 
	 * @see AbstractMapPersistenceEdition#setAvailableEdition(String)
	 */
	protected void setNotAvailableEditions(String... labels) {
		for (String label : labels)
			setNotAvailableEdition(label);
	}

	/**
	 * Concatenate each argument present into the given array like : elt1 + " " + elt2 + " " + elt3 +...
	 * 
	 * @param args The array that contains arguments.
	 * 
	 * @return The concatenation of each argument.
	 * 
	 * @see #concat(String[], CharSequence)
	 */
	protected String concat(String[] args) {
		return concat(args, ", ");
	}

	/**
	 * Concatenate each string in the <code>strings</code> array.
	 * 
	 * @param strings   An array that contains string to concatenate.
	 * @param delimiter the sequence of characters to be used between each element added to the concatenation value.
	 * @return The concatenation of each string.
	 * 
	 * @see StringJoiner
	 */
	protected String concat(String[] strings, CharSequence delimiter) {
		StringJoiner joiner = new StringJoiner(delimiter);
		for (String string : strings)
			joiner.add(string);
		return joiner.toString();
	}

	/**
	 * Concatenate each string in the list <code>strings</code> using the given delimiter.
	 * 
	 * @param strings   The list that contains string to concatenate
	 * @param delimiter the sequence of characters to be used between each element added to the concatenation value.
	 * @return The concatenation of each string.
	 */
	protected String concat(List<String> strings, CharSequence delimiter) {
		return concat(strings.toArray(new String[] {}), delimiter);
	}

	/**
	 * Concatenate each string in the list <code>strings</code> using the delimiter ", ".
	 * 
	 * @param strings   The list that contains string to concatenate
	 * @param delimiter the sequence of characters to be used between each element added to the concatenation value.
	 * @return The concatenation of each string.
	 * 
	 * @see #concat(List, CharSequence)
	 */
	protected String concat(List<String> strings) {
		return concat(strings, ", ");
	}

	/**
	 * Method used to display the given block to minecraft player.
	 * 
	 * @param block The block to display.
	 * 
	 * @return "X=" + block.getX() + " Y=" + block.getY() + " Z=" + block.getZ();
	 */
	protected String toString(Block block) {
		return DisplayHelper.toString(block);
	}

	/**
	 * Method used to display the given time to minecraft player.
	 * 
	 * @param time The time to display.
	 * 
	 * @return time.getHour() + "h " + time.getMinute() + "m " + time.getSecond() + "s";
	 */
	protected String toString(LocalTime time) {
		return DisplayHelper.toString(time);
	}

	/**
	 * Method used to display the given location to minecraft player.
	 * 
	 * @param location The location to display.
	 * @param full     If should display pitch an yaw.
	 * @return "X=" + location.getX() + " Y=" + location.getY() + " Z=" + location.getZ() + " Pitch=" + location.getPitch() + " Yaw="
	 *         + location.getYaw();
	 */
	protected String toString(Location location, boolean full) {
		return DisplayHelper.toString(location, full);
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
