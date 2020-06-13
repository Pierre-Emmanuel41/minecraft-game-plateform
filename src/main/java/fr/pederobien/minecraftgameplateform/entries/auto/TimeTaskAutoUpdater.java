package fr.pederobien.minecraftgameplateform.entries.auto;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.entries.simple.TimeTaskEntry;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTaskObserver;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftscoreboards.impl.AbstractEntryUpdater;
import fr.pederobien.minecraftscoreboards.interfaces.IObjective;

public class TimeTaskAutoUpdater extends AbstractEntryUpdater<TimeTaskEntry> implements ITimeTaskObserver {
	private LocalTime currentTime;

	/**
	 * Create an entry updater. This entry is responsible to update the source entry.
	 * 
	 * @param plugin    The plugin to register this entry to be periodically updated.
	 * @param objective The objective associated to the source entry.
	 * @param source    The source tracked by this updater.
	 */
	public TimeTaskAutoUpdater(IObjective objective, TimeTaskEntry source) {
		super(objective, source);
	}

	@Override
	public void initialize() {
		Plateform.getTimeTask().addObserver(this);
		currentTime = getSource().getTime();
	}

	@Override
	public void timeChanged(ITimeTask task) {
		LocalTime tempTime = getSource().getTime();
		if (currentTime.equals(tempTime))
			return;

		update();
		currentTime = tempTime;
	}
}
