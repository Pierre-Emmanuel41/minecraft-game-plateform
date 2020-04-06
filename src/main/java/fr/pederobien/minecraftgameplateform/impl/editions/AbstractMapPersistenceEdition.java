package fr.pederobien.minecraftgameplateform.impl.editions;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import fr.pederobien.minecraftdevelopmenttoolkit.impl.AbstractGenericMapEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public class AbstractMapPersistenceEdition<T extends IUnmodifiableNominable> extends AbstractGenericMapEdition<IMessageCode, T, IParentPersistenceEdition<T>>
		implements IMapPersistenceEdition<T> {

	public AbstractMapPersistenceEdition(String label, IMessageCode explanation) {
		super(label, explanation);
	}

	/**
	 * Parses the string argument as a signed decimal integer. The characters in the string must all be decimal digits, except that
	 * the first character may be an ASCII minus sign {@code '-'} ({@code '\u005Cu002D'}) to indicate a negative value or an ASCII
	 * plus sign {@code '+'} ({@code '\u005Cu002B'}) to indicate a positive value. The resulting integer value is returned, exactly as
	 * if the argument and the radix 10 were given as arguments to the {@link #parseInt(java.lang.String, int)} method.
	 *
	 * @param s a {@code String} containing the {@code int} representation to be parsed
	 * @return True if the given string contains a parsable integer, false otherwise.
	 */
	protected boolean isInt(String number) {
		try {
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
}
