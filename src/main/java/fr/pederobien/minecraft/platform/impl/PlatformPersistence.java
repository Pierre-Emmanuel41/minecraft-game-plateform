package fr.pederobien.minecraft.platform.impl;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import fr.pederobien.minecraft.platform.Platform;
import fr.pederobien.minecraft.platform.event.PlatformDisablePostEvent;
import fr.pederobien.minecraft.platform.interfaces.INominable;
import fr.pederobien.minecraft.platform.interfaces.IPlatformPersistence;
import fr.pederobien.persistence.interfaces.IPersistence;
import fr.pederobien.persistence.interfaces.ISerializer;
import fr.pederobien.utils.event.EventHandler;
import fr.pederobien.utils.event.EventManager;
import fr.pederobien.utils.event.IEventListener;

public class PlatformPersistence<T extends INominable> implements IPlatformPersistence<T> {
	private static final String DEFAULT_NAME = "Default";
	private IPersistence<T, ? extends ISerializer<T>> persistence;
	private Path path;
	private Function<String, T> creator;
	private Consumer<T> writeDefault;
	private T elt;

	/**
	 * Creates a platform persistence. The given path should be relative to the {@link Platform#ROOT} path. If the file associated to
	 * the name "Default" does not exist in the persistence folder, then a file configuration is created.
	 * 
	 * @param path         The persistence folder.
	 * @param creator      The supplier used to create new object.
	 * @param persistence  The persistence used to serialize deserialize objects.
	 * @param writeDefault The action to perform while serializing the object associated to the name "Default".
	 */
	public PlatformPersistence(Path path, Function<String, T> creator, IPersistence<T, ? extends ISerializer<T>> persistence, Consumer<T> writeDefault) {
		this.path = Platform.ROOT.resolve(path);
		this.creator = creator;
		this.persistence = persistence;
		this.writeDefault = writeDefault;

		writeDefaultContent();
		EventManager.registerListener(new AutomaticSerializer(this));
	}

	@Override
	public Path getPath() {
		return path;
	}

	@Override
	public boolean deserialize(String name) {
		boolean succeed = deserialize(elt = getCreator().apply(name));
		if (!succeed)
			elt = null;
		return succeed;
	}

	@Override
	public boolean deserialize(T element) {
		try {
			persistence.deserialize(element, getAbsolutePath(element.getName()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean serialize() {
		if (elt == null)
			return true;
		try {
			persistence.serialize(elt, IPersistence.LATEST, getAbsolutePath(elt.getName()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Function<String, T> getCreator() {
		return creator;
	}

	@Override
	public T get() {
		return elt;
	}

	@Override
	public void set(T elt) {
		this.elt = elt;
	}

	@Override
	public boolean exist(String name) {
		return getAbsolutePath(name).toFile().exists();
	}

	@Override
	public boolean delete(String name) {
		return getAbsolutePath(name).toFile().delete();
	}

	@Override
	public List<String> list() {
		String[] list = getPath().toFile().list();
		List<String> names = new ArrayList<String>();
		for (String name : list)
			names.add(name.substring(0, name.indexOf(persistence.getExtension())));
		return names;
	}

	/**
	 * Get the absolute path leading to the file associated to the given name.
	 * 
	 * @param name The file name.
	 * 
	 * @return The path leading the file.
	 */
	private Path getAbsolutePath(String name) {
		return getPath().resolve(name.concat(persistence.getExtension()));
	}

	private void writeDefaultContent() {
		File folder = getPath().toFile();
		if (!folder.exists())
			folder.mkdirs();

		Path defaultPath = getAbsolutePath(DEFAULT_NAME);

		try {
			if (!defaultPath.toFile().exists()) {
				T defaultElement = creator.apply(DEFAULT_NAME);
				persistence.serialize(defaultElement, IPersistence.LATEST, defaultPath.toString());
				writeDefault.accept(defaultElement);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class AutomaticSerializer implements IEventListener {
		private IPlatformPersistence<T> persistence;

		private AutomaticSerializer(IPlatformPersistence<T> persistence) {
			this.persistence = persistence;
		}

		@EventHandler
		private void onPlatformDisabled(PlatformDisablePostEvent event) {
			persistence.serialize();
		}
	}
}
