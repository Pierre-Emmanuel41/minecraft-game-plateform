package fr.pederobien.minecraft.game.platform.impl.runtime.task.state;

import fr.pederobien.minecraft.game.platform.interfaces.runtime.task.state.IStateTimeTask;

public class PauseTimeTaskState extends AbstractTimeTaskState {

	public PauseTimeTaskState(IStateTimeTask task) {
		super(task);
	}

	@Override
	public void run() {
		setTotalTime(getTotalTime().plusSeconds(1));
		setPauseTime(getPauseTime().plusSeconds(1));
		getTask().notifyObservers();
	}

	@Override
	public void relaunched() {
		getTask().setCurrentState(getTask().getRunState());
	}

	@Override
	public void stop() {
		cancel();
		getTask().setCurrentState(getTask().getInitialState());
	}
}
