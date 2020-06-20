package fr.pederobien.minecraftgameplateform.entries.auto;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.entries.simple.BorderConfigurationEntry;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTaskObserver;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.timeline.ITimeLineObserver;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftscoreboards.impl.AbstractEntryUpdater;
import fr.pederobien.minecraftscoreboards.interfaces.IObjective;

public class BorderConfigurationEntryUpdater<T extends BorderConfigurationEntry> extends AbstractEntryUpdater<T> implements ITimeTaskObserver, ITimeLineObserver {

	/**
	 * Create an entry updater. This entry is responsible to update the source entry.
	 * 
	 * @param objective The objective associated to the source entry.
	 * @param source    The source tracked by this updater.
	 */
	public BorderConfigurationEntryUpdater(IObjective objective, T source) {
		super(objective, source);
	}

	@Override
	public void initialize() {
		Plateform.getTimeLine().addObserver(getConfiguration().getStartTime(), this);
	}

	@Override
	public void timeChanged(LocalTime time) {
		Plateform.getTimeTask().addObserver(this);
	}

	@Override
	public void timeChanged(ITimeTask task) {
		update();
	}

	/**
	 * @return The configuration associated to the source entry.
	 */
	protected IBorderConfiguration getConfiguration() {
		return getSource().getConfiguration();
	}
}