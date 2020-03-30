package fr.pederobien.minecraftgameplateform.impl.runtime.launchers;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import fr.pederobien.minecraftgameplateform.interfaces.runtime.launchers.ILauncher;

public abstract class AbstractLauncher extends BukkitRunnable implements ILauncher {

	@Override
	public void run(Plugin plugin, long delay, long period) {
		runTaskTimer(plugin, delay, period);
	}
}
