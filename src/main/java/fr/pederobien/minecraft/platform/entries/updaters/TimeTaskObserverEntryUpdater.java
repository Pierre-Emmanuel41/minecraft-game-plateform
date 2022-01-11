package fr.pederobien.minecraft.platform.entries.updaters;

import fr.pederobien.minecraft.game.event.TimeTaskStartPostEvent;
import fr.pederobien.minecraft.game.event.TimeTaskStopPostEvent;
import fr.pederobien.minecraft.game.event.TimeTaskTimeChangePostEvent;
import fr.pederobien.minecraft.platform.Platform;
import fr.pederobien.minecraft.scoreboards.impl.EntryUpdater;
import fr.pederobien.utils.event.EventHandler;
import fr.pederobien.utils.event.EventManager;
import fr.pederobien.utils.event.IEventListener;

public class TimeTaskObserverEntryUpdater extends EntryUpdater implements IEventListener {

	@Override
	public void initialize() {
		EventManager.registerListener(this);
	}

	@EventHandler
	private void onTimeTaskStart(TimeTaskStartPostEvent event) {
		setActivated(true);
	}

	@EventHandler
	private void onTimeTaskStop(TimeTaskStopPostEvent event) {
		setActivated(false);
	}

	@EventHandler
	private void onTimeChange(TimeTaskTimeChangePostEvent event) {
		if (!event.getTask().equals(Platform.get(getPlugin()).getTimeLine().getTimeTask()))
			return;

		update();
	}
}
