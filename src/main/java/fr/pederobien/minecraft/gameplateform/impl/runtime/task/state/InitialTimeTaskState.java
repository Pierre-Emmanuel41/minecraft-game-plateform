package fr.pederobien.minecraft.gameplateform.impl.runtime.task.state;

import java.time.LocalTime;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraft.gameplateform.interfaces.runtime.task.state.IStateTimeTask;
import fr.pederobien.minecraftmanagers.BukkitManager;

public class InitialTimeTaskState extends AbstractTimeTaskState {

	public InitialTimeTaskState(IStateTimeTask task) {
		super(task);
	}

	@Override
	public void start(Plugin plugin) {
		setTotalTime(LocalTime.of(0, 0, 0));
		setGameTime(LocalTime.of(0, 0, 0));
		setPauseTime(LocalTime.of(0, 0, 0));
		getTask().setBukkitTask(BukkitManager.getScheduler().runTaskTimer(plugin, getTask(), 0, 20));
	}

	@Override
	public void run() {
		getTask().setCurrentState(getTask().getRunState());
		getTask().notifyObservers();
	}
}
