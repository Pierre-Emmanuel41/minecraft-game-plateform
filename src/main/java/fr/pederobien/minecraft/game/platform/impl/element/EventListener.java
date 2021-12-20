package fr.pederobien.minecraft.game.platform.impl.element;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraft.game.platform.interfaces.element.IEventListener;

public class EventListener implements IEventListener {
	private boolean isRegistered, isActivated;

	public EventListener() {
		isRegistered = false;
		isActivated = false;
	}

	@Override
	public final void register(Plugin plugin) {
		if (isRegistered)
			return;
		isRegistered = true;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@Override
	public boolean isRegistered() {
		return isRegistered;
	}

	@Override
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	@Override
	public boolean isActivated() {
		return isActivated;
	}
}
