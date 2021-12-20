package fr.pederobien.minecraft.game.platform.entries.simple;

import java.time.LocalTime;

import org.bukkit.entity.Player;

import fr.pederobien.minecraft.game.platform.Platform;
import fr.pederobien.minecraft.game.platform.entries.PlateformEntry;
import fr.pederobien.minecraft.game.platform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftdevelopmenttoolkit.utils.DisplayHelper;

public abstract class TimeTaskEntry extends PlateformEntry {

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

	/**
	 * @return A task that represent the time during a game.
	 */
	protected ITimeTask getTask() {
		return Platform.getTimeTask();
	}

	@Override
	protected String updateCurrentValue(Player player) {
		return DisplayHelper.toString(getTime(), false);
	}
}
