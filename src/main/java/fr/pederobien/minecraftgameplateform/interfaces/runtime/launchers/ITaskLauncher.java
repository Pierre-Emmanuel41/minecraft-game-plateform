package fr.pederobien.minecraftgameplateform.interfaces.runtime.launchers;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.IObservableTimeTask;

public interface ITaskLauncher extends ILauncher {

	/**
	 * @return the time task managed by this task launcher as observable task.
	 */
	IObservableTimeTask getTask();
}
