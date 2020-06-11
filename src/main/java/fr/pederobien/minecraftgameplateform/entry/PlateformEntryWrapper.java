package fr.pederobien.minecraftgameplateform.entry;

import fr.pederobien.minecraftdevelopmenttoolkit.impl.entry.ToolkitEntryWrapper;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftscoreboards.interfaces.IEntry;

public class PlateformEntryWrapper<T extends IEntry> extends ToolkitEntryWrapper<T> {

	/**
	 * Constructs a wrapper for the given entry. This wrapper propose methods to display player language sensitive messages.
	 * 
	 * @param source The entry to wrap.
	 */
	public PlateformEntryWrapper(T source) {
		super(source);
	}

	@Override
	protected IMinecraftNotificationCenter getNotificationCenter() {
		return Plateform.getNotificationCenter();
	}
}
