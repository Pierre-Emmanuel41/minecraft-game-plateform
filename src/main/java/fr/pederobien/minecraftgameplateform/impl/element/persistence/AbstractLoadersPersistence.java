package fr.pederobien.minecraftgameplateform.impl.element.persistence;

import java.nio.file.Path;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import fr.pederobien.minecraftgameplateform.exceptions.persistence.LoaderNotFoundException;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IDefaultContent;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.ILoadersPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistenceLoader;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public abstract class AbstractLoadersPersistence<T extends IUnmodifiableNominable, U extends IPersistenceLoader<T>> extends AbstractPersistence<T>
		implements ILoadersPersistence<T, U> {
	private NavigableMap<Double, U> loaders;

	protected AbstractLoadersPersistence(IDefaultContent defaultContent) {
		this(Plateform.ROOT, defaultContent);
	}

	protected AbstractLoadersPersistence(Path path, IDefaultContent defaultContent) {
		super(path, defaultContent);
		loaders = new TreeMap<Double, U>();
	}

	@Override
	public ILoadersPersistence<T, U> register(U loader) {
		loaders.put(loader.getVersion(), loader);
		return this;
	}

	@Override
	public ILoadersPersistence<T, U> unregister(Double version) {
		loaders.remove(version);
		return this;
	}

	@Override
	public Map<Double, U> getLoaders() {
		return Collections.unmodifiableMap(loaders);
	}

	@Override
	public U getLoader(Double version) {
		U loader = loaders.get(version);
		if (loader == null)
			throw new LoaderNotFoundException(version);
		return loader;
	}

	@Override
	public Double getVersion() {
		return loaders.lastEntry().getKey();
	}
}
