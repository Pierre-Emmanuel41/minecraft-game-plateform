package fr.pederobien.minecraftgameplateform.entry.simple;

import java.time.LocalTime;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftdevelopmenttoolkit.utils.DisplayHelper;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public abstract class TimeTaskEntry extends PlateformEntry {

	/**
	 * Create an entry.
	 * 
	 * @param score The line number of this entry in the player objective.
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
		return Plateform.getTimeTask();
	}

	@Override
	protected String updateCurrentValue(Player player) {
		return DisplayHelper.toString(getTime(), false);
	}
}
