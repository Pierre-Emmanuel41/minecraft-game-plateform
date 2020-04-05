package fr.pederobien.minecraftgameplateform.impl.element.persistence;

import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistenceLoader;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public class AbstractPersistenceLoader<T extends IUnmodifiableNominable> implements IPersistenceLoader<T> {
	private Double version;
	private T elt;

	protected AbstractPersistenceLoader(Double version, T elt) {
		this.version = version;
		this.elt = elt;
	}

	@Override
	public Double getVersion() {
		return version;
	}

	@Override
	public T get() {
		return elt;
	}

	/**
	 * Parses the string argument as a signed decimal integer. The characters in the string must all be decimal digits, except that
	 * the first character may be an ASCII minus sign {@code '-'} ({@code '\u005Cu002D'}) to indicate a negative value or an ASCII
	 * plus sign {@code '+'} ({@code '\u005Cu002B'}) to indicate a positive value. The resulting integer value is returned, exactly as
	 * if the argument and the radix 10 were given as arguments to the {@link #parseInt(java.lang.String, int)} method.
	 *
	 * @param number a {@code String} containing the {@code int} representation to be parsed.
	 * 
	 * @return the integer value represented by the argument in decimal.
	 * 
	 * @exception NumberFormatException if the string does not contain a parsable integer.
	 */
	protected int toInt(String number) {
		return Integer.parseInt(number);
	}
}
