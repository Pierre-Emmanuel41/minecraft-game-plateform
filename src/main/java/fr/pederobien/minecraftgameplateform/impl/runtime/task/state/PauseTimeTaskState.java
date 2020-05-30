package fr.pederobien.minecraftgameplateform.impl.runtime.task.state;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;

public class PauseTimeTaskState extends AbstractTimeTaskState {

	public PauseTimeTaskState(IStateTimeTask task) {
		super(task);
	}

	@Override
	public void run() {
		setTotalTime(getTotalTime().plusSeconds(1));
		setPauseTime(getPauseTime().plusSeconds(1));
	}

	@Override
	public void relaunched() {
		getTask().setCurrentState(getTask().getRunState());
	}

	@Override
	public void stop() {
		cancel();
	}
}
