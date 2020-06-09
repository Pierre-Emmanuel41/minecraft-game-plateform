package fr.pederobien.minecraftgameplateform.entry.auto;

import fr.pederobien.minecraftgameplateform.entry.simple.TimeTaskEntry;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTaskObserver;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftscoreboards.impl.AbstractEntryUpdater;
import fr.pederobien.minecraftscoreboards.interfaces.ISimpleObjective;

public class TimeTaskAutoUpdater extends AbstractEntryUpdater<TimeTaskEntry> implements ITimeTaskObserver {

	/**
	 * Create an entry updater. This entry is responsible to update the source entry.
	 * 
	 * @param plugin    The plugin to register this entry to be periodically updated.
	 * @param objective The objective associated to the source entry.
	 * @param source    The source tracked by this updater.
	 */
	public TimeTaskAutoUpdater(ISimpleObjective objective, TimeTaskEntry source) {
		super(objective, source);
	}

	@Override
	public void initialize() {
		Plateform.getTimeTask().addObserver(this);
	}

	@Override
	public void timeChanged(ITimeTask task) {
		update();
	}
}
