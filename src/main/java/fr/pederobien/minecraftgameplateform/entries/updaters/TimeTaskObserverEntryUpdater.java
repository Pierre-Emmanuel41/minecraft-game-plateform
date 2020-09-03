package fr.pederobien.minecraftgameplateform.entries.updaters;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.IObsTimeTask;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftscoreboards.impl.EntryUpdater;

public class TimeTaskObserverEntryUpdater extends EntryUpdater implements IObsTimeTask {

	@Override
	public void initialize() {
		Plateform.getTimeTask().addObserver(this);
	}

	@Override
	public void timeChanged(ITimeTask task) {
		update();
	}
}
