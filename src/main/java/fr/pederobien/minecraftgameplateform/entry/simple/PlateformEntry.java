package fr.pederobien.minecraftgameplateform.entry.simple;

import fr.pederobien.minecraftdevelopmenttoolkit.impl.entry.ToolkitEntry;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public abstract class PlateformEntry extends ToolkitEntry {

	/**
	 * Constructs an entry that propose methods to display player language sensitive messages.
	 * 
	 * @param score The line number of this entry.
	 */
	protected PlateformEntry(int score) {
		super(score);
	}

	@Override
	protected IMinecraftNotificationCenter getNotificationCenter() {
		return Plateform.getNotificationCenter();
	}
}
