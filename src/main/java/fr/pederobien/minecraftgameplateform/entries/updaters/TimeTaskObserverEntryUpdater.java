package fr.pederobien.minecraftgameplateform.entries.updaters;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.IObsTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftscoreboards.impl.EntryUpdater;

public class TimeTaskObserverEntryUpdater extends EntryUpdater implements IObsTimeTask {

	@Override
	public void initialize() {
		Plateform.getTimeTask().addObserver(this);
	}

	@Override
	public void onStart(ITimeTask task) {
		setActivated(true);
	}

	@Override
	public void onPause(ITimeTask task) {

	}

	@Override
	public void onRelaunched(ITimeTask task) {

	}

	@Override
	public void onStop(ITimeTask task) {
		setActivated(false);
	}

	@Override
	public void timeChanged(ITimeTask task) {
		update();
	}
}
