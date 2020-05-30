package fr.pederobien.minecraftgameplateform.impl.runtime.launchers;

import fr.pederobien.minecraftgameplateform.impl.runtime.task.TimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.observer.IObservable;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.launchers.ITaskLauncher;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.ITimeTaskObserver;

public class TaskLauncher extends AbstractLauncher implements ITaskLauncher {
	private TimeTask task;

	public TaskLauncher() {
		task = new TimeTask();
	}

	@Override
	public void pause() {
		task.pause();
	}

	@Override
	public void relaunched() {
		task.relaunched();
	}

	@Override
	public void run() {
		task.run();
	}

	@Override
	public IObservable<ITimeTaskObserver> getTask() {
		return task;
	}

	@Override
	public void cancel() {
		super.cancel();
		task.cancel();
	}
}
