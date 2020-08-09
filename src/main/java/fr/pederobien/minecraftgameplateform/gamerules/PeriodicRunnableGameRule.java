package fr.pederobien.minecraftgameplateform.gamerules;

import org.bukkit.scheduler.BukkitTask;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.BukkitManager;

public abstract class PeriodicRunnableGameRule<T> extends RunnableGameRule<T> implements Runnable {
	private BukkitTask task;

	protected PeriodicRunnableGameRule(String name, T defaultValue, Class<T> type, IMinecraftMessageCode explanation) {
		super(name, defaultValue, type, explanation);
	}

	@Override
	public void start() {
		task = BukkitManager.getScheduler().runTaskTimer(Plateform.getPlugin(), this, 0, getPeriod());
		setRunning(true);
	}

	@Override
	public void stop() {
		BukkitManager.getScheduler().cancelTask(task.getTaskId());
		setRunning(false);
	}
}
