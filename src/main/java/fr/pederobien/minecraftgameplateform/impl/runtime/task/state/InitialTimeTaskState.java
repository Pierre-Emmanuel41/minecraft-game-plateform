package fr.pederobien.minecraftgameplateform.impl.runtime.task.state;

import java.time.LocalTime;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.task.state.IStateTimeTask;
import fr.pederobien.minecraftmanagers.BukkitManager;

public class InitialTimeTaskState extends AbstractTimeTaskState {

	public InitialTimeTaskState(IStateTimeTask task) {
		super(task);
	}

	@Override
	public void start(Plugin plugin) {
		getTask().setBukkitTask(BukkitManager.getScheduler().runTaskTimer(plugin, this, 0, 20));
	}

	@Override
	public void run() {
		setTotalTime(LocalTime.of(0, 0, 0));
		getTask().setCurrentState(getTask().getRunState());
	}
}
