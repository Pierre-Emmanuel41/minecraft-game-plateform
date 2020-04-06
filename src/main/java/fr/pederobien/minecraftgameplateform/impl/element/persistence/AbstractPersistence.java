package fr.pederobien.minecraftgameplateform.impl.element.persistence;

import java.nio.file.Path;
import java.nio.file.Paths;

import fr.pederobien.minecraftgameplateform.exceptions.IllegalPathException;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IDefaultContent;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public abstract class AbstractPersistence<T extends IUnmodifiableNominable> implements IPersistence<T> {
	protected static final Path ROOT = Paths.get("plugins", "minecraft-game-plateform");
	private Path path;
	private IDefaultContent defaultContent;

	protected AbstractPersistence(Path path, IDefaultContent defaultContent) {
		checkPath(path);
		this.path = path;
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

	private void checkPath(Path path) {
		if (!path.startsWith(ROOT))
			throw new IllegalPathException(path);
	}
}
