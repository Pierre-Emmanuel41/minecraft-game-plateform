package fr.pederobien.minecraftgameplateform.gamerules;

import org.bukkit.scheduler.BukkitTask;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IRunnableGameRule;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.BukkitManager;

public abstract class RunnableGameRule<T> extends GameRule<T> implements IRunnableGameRule<T> {
	private long period;
	private boolean isRunning;
	private BukkitTask task;

	protected RunnableGameRule(String name, T defaultValue, Class<T> type, IMinecraftMessageCode explanation) {
		super(name, defaultValue, type, explanation);
	}

	@Override
	public long getPeriod() {
		return period;
	}

	@Override
	public void setPeriod(long period) {
		if (isRunning && this.period != period) {
			this.period = period;
			stop();
			start();
		}
	}

	@Override
	public void start() {
		task = BukkitManager.getScheduler().runTaskTimer(Plateform.getPlugin(), this, 0, getPeriod());
		isRunning = true;
	}

	@Override
	public void stop() {
		BukkitManager.getScheduler().cancelTask(task.getTaskId());
		isRunning = false;
	}

	@Override
	public boolean isRunning() {
		return isRunning;
	}
}
