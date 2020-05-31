package fr.pederobien.minecraftgameplateform.impl.runtime.task.state;

import java.time.LocalTime;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.exceptions.StateException;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;
import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.ITimeTaskState;
import fr.pederobien.minecraftmanagers.BukkitManager;

public abstract class AbstractTimeTaskState implements ITimeTaskState {
	private IStateTimeTask task;
	private static LocalTime totalTime, gameTime, pauseTime;

	protected AbstractTimeTaskState(IStateTimeTask task) {
		this.task = task;
	}

	@Override
	public void start(Plugin plugin) {
		throw new StateException(this);
	}

	@Override
	public void pause() {
		throw new StateException(this);
	}

	@Override
	public void relaunched() {
		throw new StateException(this);
	}

	@Override
	public void stop() {
		throw new StateException(this);
	}

	@Override
	public void run() {
		throw new StateException(this);
	}

	protected IStateTimeTask getTask() {
		return task;
	}

	protected void cancel() {
		BukkitManager.getScheduler().cancelTask(getTask().getBukkitTask().getTaskId());
	}

	@Override
	public LocalTime getTotalTime() {
		return totalTime == null ? LocalTime.of(0, 0, 0) : totalTime;
	}

	protected void setTotalTime(LocalTime totalTime) {
		AbstractTimeTaskState.totalTime = totalTime;
	}

	@Override
	public LocalTime getGameTime() {
		return gameTime == null ? LocalTime.of(0, 0, 0) : gameTime;
	}

	protected void setGameTime(LocalTime gameTime) {
		AbstractTimeTaskState.gameTime = gameTime;
	}

	@Override
	public LocalTime getPauseTime() {
		return pauseTime == null ? LocalTime.of(0, 0, 0) : pauseTime;
	}

	protected void setPauseTime(LocalTime pauseTime) {
		AbstractTimeTaskState.pauseTime = pauseTime;
	}
}
