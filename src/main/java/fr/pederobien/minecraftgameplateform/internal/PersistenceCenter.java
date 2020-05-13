package fr.pederobien.minecraftgameplateform.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import fr.pederobien.minecraftdevelopmenttoolkit.utils.FileWriterHelper;
import fr.pederobien.minecraftgameplateform.impl.element.AbstractNominable;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftgameplateform.internal.persistence.PersistenceCenterPersistence;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
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
			Plateform.getPlugin().getLogger().info("Registering persistence " + persistence.getClass());
			register(persistence);
		} else if (persistence.forceUpdate() || !version.equals(persistence.getVersion())) {
			Plateform.getPlugin().getLogger().info("Updating persistence " + persistence.getClass());
			update(persistence);
		}
	}

	@Override
	public void save() {
		centerPersistence.save();
	}

	private <T extends IUnmodifiableNominable> void register(IMinecraftPersistence<T> persistence) {
		FileWriterHelper.mkdirs(persistence.getPath());
		versions.put(persistence.getClass().getName(), persistence.getVersion());
		FileWriterHelper.write(persistence.getAbsolutePath(persistence.getDefaultContent().getName()), persistence.getDefaultContent().getDefaultContent());
	}

	private <T extends IUnmodifiableNominable> void update(IMinecraftPersistence<T> persistence) {
		try {
			persistence.load(persistence.getDefaultContent().getName());
			persistence.save();
			persistence.set(null);
			versions.put(persistence.getClass().getName(), persistence.getVersion());
		} catch (FileNotFoundException e) {
			FileWriterHelper.write(persistence.getAbsolutePath(persistence.getDefaultContent().getName()), persistence.getDefaultContent().getDefaultContent());
		}
	}
}
