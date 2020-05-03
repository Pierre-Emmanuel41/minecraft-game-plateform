package fr.pederobien.minecraftgameplateform.impl.element.persistence;

import java.nio.file.Path;

import fr.pederobien.minecraftgameplateform.exceptions.persistence.IllegalPathException;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IDefaultContent;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public abstract class AbstractPersistence<T extends IUnmodifiableNominable> implements IPersistence<T> {
	protected static final Path ROOT = Plateform.ROOT;
	private Path path;
	private IDefaultContent defaultContent;

	protected AbstractPersistence(Path path, IDefaultContent defaultContent) {
		setInternalPath(path);
		this.defaultContent = defaultContent;
	}

	@Override
	public Path getPath() {
		return path;
	}

	@Override
	public IDefaultContent getDefaultContent() {
		return defaultContent;
	}

	@Override
	public void setPath(Path path) {
		throw new UnsupportedOperationException("This method cannot be called");
	}

	protected void setInternalPath(Path path) {
		checkPath(path);
		this.path = path;
	}

	private void checkPath(Path path) {
		if (!path.startsWith(ROOT))
			throw new IllegalPathException(path);
	}
}
