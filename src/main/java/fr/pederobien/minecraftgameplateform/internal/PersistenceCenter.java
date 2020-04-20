package fr.pederobien.minecraftgameplateform.internal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import fr.pederobien.minecraftgameplateform.impl.element.AbstractNominable;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;
import fr.pederobien.minecraftgameplateform.internal.persistence.PersistenceCenterPersistence;

public class PersistenceCenter extends AbstractNominable implements IPersistenceCenter {
	private Map<String, Double> versions;
	private IPersistence<IPersistenceCenter> persistence;

	private PersistenceCenter() {
		super("register");
		versions = new HashMap<String, Double>();
		try {
			persistence = new PersistenceCenterPersistence(this).load(getName());
		} catch (IOException e) {

		}
		registerOrUpdate(persistence);
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
	public <T extends IUnmodifiableNominable> void registerOrUpdate(IPersistence<T> persistence) {
		Double version = versions.get(persistence.getClass().getName());

		if (version == null) {
			System.out.println("Registering persistence");
			register(persistence);
		} else if (!version.equals(persistence.getVersion())) {
			System.out.println("Updating persistence");
			update(persistence);
		}
	}

	@Override
	public void save() {
		persistence.save();
	}

	private <T extends IUnmodifiableNominable> void register(IPersistence<T> persistence) {
		File file = persistence.getPath().toFile();
		if (!file.exists())
			file.mkdirs();

		versions.put(persistence.getClass().getName(), persistence.getVersion());
		write(persistence.getAbsolutePath(persistence.getDefaultContent().getName()).toFile(), persistence.getDefaultContent().getDefaultContent());
	}

	private <T extends IUnmodifiableNominable> void update(IPersistence<T> persistence) {
		try {
			persistence.load(persistence.getDefaultContent().getName());
			persistence.save();
			persistence.set(null);
			versions.put(persistence.getClass().getName(), persistence.getVersion());
		} catch (IOException e) {

		}
	}

	private void write(File file, String toWrite) {
		BufferedWriter writer = null;
		try {
			if (!file.exists())
				file.createNewFile();

			// Writing default content
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(toWrite);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {

			}
		}
	}
}
