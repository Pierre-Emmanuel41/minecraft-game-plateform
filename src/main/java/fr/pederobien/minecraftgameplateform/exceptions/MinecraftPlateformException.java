package fr.pederobien.minecraftgameplateform.exceptions;

import java.util.StringJoiner;

import fr.pederobien.minecraftgameplateform.utils.Plateform;

public abstract class MinecraftPlateformException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public final String getMessage() {
		StringJoiner joiner = new StringJoiner("\n", "\n", "");
		joiner.add("Plateform version : " + Plateform.getVersion());
		StringJoiner returnedJoiner = getInternalMessage(joiner);
		if (!joiner.equals(returnedJoiner))
			throw new InternalBadException(getClass().getName());
		return returnedJoiner.toString();
	}

	/**
	 * Get the internal message specific to this exception.
	 * 
	 * @param joiner The {@link StringJoiner} used to append the specific message. The delimiter is "\n".
	 * 
	 * @return The given string joiner. If the returned joiner is not the given joiner, the method {@link #getMessage()} will throw a
	 *         {@link InternalBadException}.
	 */
	protected abstract StringJoiner getInternalMessage(StringJoiner joiner);
}
