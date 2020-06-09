package fr.pederobien.minecraftgameplateform.entry.simple;

import fr.pederobien.minecraftdevelopmenttoolkit.impl.entry.ToolkitEntry;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public abstract class PlateformEntry extends ToolkitEntry {

	/**
	 * Create an entry.
	 * 
	 * @param score The line number of this entry in the player objective.
	 */
	protected PlateformEntry(int score) {
		super(score);
	}

	@Override
	protected IMinecraftNotificationCenter getNotificationCenter() {
		return Plateform.getNotificationCenter();
	}
}
