package fr.pederobien.minecraft.platform.impl;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import fr.pederobien.minecraft.platform.Platform;
import fr.pederobien.minecraft.platform.interfaces.INominable;
import fr.pederobien.minecraft.platform.interfaces.IPlatformPersistence;
import fr.pederobien.persistence.interfaces.IPersistence;
import fr.pederobien.persistence.interfaces.ISerializer;

public class PlatformPersistence<T extends INominable> implements IPlatformPersistence<T> {
	private IPersistence<T, ? extends ISerializer<T>> persistence;
	private Path path;
	private Function<String, T> creator;
	private T elt;

	/**
	 * Creates a platform persistence. The given path should be relative to the {@link Platform#ROOT} path.
	 * 
	 * @param path        The persistence folder.
	 * @param creator     The supplier used to create new object.
	 * @param persistence The persistence used to serialize deserialize objects.
	 */
	public PlatformPersistence(Path path, Function<String, T> creator, IPersistence<T, ? extends ISerializer<T>> persistence) {
		this.path = Platform.ROOT.resolve(path);
		this.creator = creator;
		this.persistence = persistence;
	}

	@Override
	public Path getPath() {
		return path;
	}

	@Override
	public boolean deserialize(String name) {
		return persistence.deserialize(get(), getAbsolutePath(name).toString());
	}

	@Override
	public boolean serialize() {
		if (elt == null)
			return true;
		return persistence.serialize(elt, IPersistence.LATEST, getAbsolutePath(elt.getName()).toString());
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
}
