package fr.pederobien.minecraftgameplateform.entries.auto;

import java.time.LocalTime;

import fr.pederobien.minecraftgameplateform.entries.simple.TimeTaskEntry;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTask;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftscoreboards.interfaces.IObjective;

public class WorldBorderCountDownAutoUpdater extends TimeTaskAutoUpdater {

	public WorldBorderCountDownAutoUpdater(IObjective objective, TimeTaskEntry source) {
		super(objective, source);
	}

	@Override
	public void timeChanged(ITimeTask task) {
		if (getSource().getTime().equals(LocalTime.of(0, 0, 0))) {
			Plateform.getTimeTask().removeObserver(this);
			getObjective().removeEntry(getScore());
			return;
		}
		super.timeChanged(task);
	}
}
