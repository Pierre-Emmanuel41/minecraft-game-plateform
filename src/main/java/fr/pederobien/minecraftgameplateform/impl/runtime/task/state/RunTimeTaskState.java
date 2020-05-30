package fr.pederobien.minecraftgameplateform.impl.runtime.task.state;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;

public class RunTimeTaskState extends AbstractTimeTaskState {

	public RunTimeTaskState(IStateTimeTask task) {
		super(task);
	}

	@Override
	public void run() {
		setTotalTime(getTotalTime().plusSeconds(1));
		setGameTime(getGameTime().plusSeconds(1));
	}

	@Override
	public void pause() {
		getTask().setCurrentState(getTask().getPauseState());
	}

	@Override
	public void stop() {
		cancel();
	}
}
