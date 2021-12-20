package fr.pederobien.minecraft.game.platform.internal;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import fr.pederobien.minecraft.game.platform.GamePlatformPlugin;
import fr.pederobien.minecraft.game.platform.impl.element.AbstractNominable;
import fr.pederobien.minecraft.game.platform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraft.game.platform.internal.persistence.PersistenceCenterPersistence;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public class PersistenceCenter extends AbstractNominable implements IPersistenceCenter {
	private Map<String, Double> versions;
	private IMinecraftPersistence<IPersistenceCenter> centerPersistence;

	private PersistenceCenter() {
		super("register");
		versions = new HashMap<String, Double>();
		try {
			centerPersistence = new PersistenceCenterPersistence(this);
			centerPersistence.load(getName());
		} catch (IOException e) {

		}
		registerOrUpdate(centerPersistence);
	}

	public static IPersistenceCenter getInstance() {
		return SingletonHolder.REGISTER;
	}

	private static class SingletonHolder {
		public static final IPersistenceCenter REGISTER = new PersistenceCenter();
	}

	@Override
	public void register(String className, double version) {
		versions.put(className, version);
	}

	@Override
	public Map<String, Double> getPersistencies() {
		return Collections.unmodifiableMap(versions);
	}

	@Override
	public <T extends IUnmodifiableNominable> void registerOrUpdate(IMinecraftPersistence<T> persistence) {
		Double version = versions.get(persistence.getClass().getName());

		if (version == null) {
			GamePlatformPlugin.instance().getLogger().info("Registering persistence " + persistence.getClass());
			versions.put(persistence.getClass().getName(), persistence.getVersion());
			writeDefaultContent(persistence);
		} else if (persistence.forceUpdate() || !version.equals(persistence.getVersion())) {
			GamePlatformPlugin.instance().getLogger().info("Updating persistence " + persistence.getClass());
			persistence.update();
			versions.put(persistence.getClass().getName(), persistence.getVersion());
		}

		// When the default content does not exist
		if (!persistence.getAbsolutePath(persistence.getDefault()).toFile().exists())
			writeDefaultContent(persistence);
	}

	@Override
	public void save() {
		centerPersistence.save();
	}

	private <T extends IUnmodifiableNominable> void writeDefaultContent(IMinecraftPersistence<T> persistence) {
		persistence.getPath().toFile().mkdirs();
		persistence.saveDefault();
	}
}
