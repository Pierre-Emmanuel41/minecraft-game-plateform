package fr.pederobien.minecraftgameplateform.impl.element;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.interfaces.element.IEventListener;

public abstract class AbstractEventListener implements IEventListener {
	private boolean isRegistered, isActivated;

	protected AbstractEventListener() {
		isRegistered = false;
		isActivated = true;
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
