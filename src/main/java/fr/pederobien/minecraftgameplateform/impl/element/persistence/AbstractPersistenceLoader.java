package fr.pederobien.minecraftgameplateform.impl.element.persistence;

import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistenceLoader;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public class AbstractPersistenceLoader<T extends IUnmodifiableNominable> implements IPersistenceLoader<T> {
	private Double version;
	private T elt;

	protected AbstractPersistenceLoader(Double version, T elt) {
		this.version = version;
		this.elt = elt;
	}

	@Override
	public Double getVersion() {
		return version;
	}

	@Override
	public T get() {
		return elt;
	}
}
