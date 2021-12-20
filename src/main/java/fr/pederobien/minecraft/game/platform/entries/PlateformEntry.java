package fr.pederobien.minecraft.game.platform.entries;

import fr.pederobien.minecraft.game.platform.Platform;
import fr.pederobien.minecraftdevelopmenttoolkit.impl.entry.ToolkitEntry;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;

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
		return Platform.getNotificationCenter();
	}
}
