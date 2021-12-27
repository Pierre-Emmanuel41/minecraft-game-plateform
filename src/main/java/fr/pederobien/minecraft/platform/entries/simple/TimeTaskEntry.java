package fr.pederobien.minecraft.platform.entries.simple;

import java.time.LocalTime;

import org.bukkit.entity.Player;

import fr.pederobien.minecraft.game.impl.DisplayHelper;
import fr.pederobien.minecraft.scoreboards.impl.CodeEntry;

public abstract class TimeTaskEntry extends CodeEntry {

	/**
	 * Constructs an entry that propose methods to display player language sensitive messages.
	 * 
	 * @param score The line number of this entry.
	 */
	protected TimeTaskEntry(int score) {
		super(score);
	}

	/**
	 * @return The time to display.
	 */
	public abstract LocalTime getTime();

	@Override
	protected String updateCurrentValue(Player player) {
		return DisplayHelper.toString(getTime(), false);
	}
}
