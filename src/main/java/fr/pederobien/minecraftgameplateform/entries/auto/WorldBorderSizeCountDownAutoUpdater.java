package fr.pederobien.minecraftgameplateform.entries.auto;

import fr.pederobien.minecraftgameplateform.entries.simple.WorldBorderSizeCountDownEntry;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTaskObserver;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftscoreboards.impl.AbstractEntryUpdater;
import fr.pederobien.minecraftscoreboards.interfaces.IObjective;

public class WorldBorderSizeCountDownAutoUpdater extends AbstractEntryUpdater<WorldBorderSizeCountDownEntry> implements ITimeTaskObserver {

	public WorldBorderSizeCountDownAutoUpdater(IObjective objective, WorldBorderSizeCountDownEntry source) {
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
