package fr.pederobien.minecraftgameplateform.gamerules;

import org.bukkit.event.Listener;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class EventRunnableGameRule<T> extends RunnableGameRule<T> implements Listener {
	private boolean isRegistered;

	protected EventRunnableGameRule(String name, T defaultValue, Class<T> type, IMinecraftMessageCode explanation) {
		super(name, defaultValue, type, explanation);
		isRegistered = false;
	}

	@Override
	public void start() {
		if (!isRegistered) {
			System.out.println("Registering rule : " + getName());
			Plateform.getPlugin().getServer().getPluginManager().registerEvents(this, Plateform.getPlugin());
			isRegistered = true;
		}
		setRunning(true);
	}

	@Override
	public void stop() {
		setRunning(false);
	}
}
