package fr.pederobien.minecraftgameplateform.impl.element.persistence;

import java.nio.file.Path;

import fr.pederobien.minecraftgameplateform.exceptions.persistence.IllegalPathException;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IDefaultContent;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.persistence.impl.xml.AbstractXmlPersistence;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public abstract class AbstractMinecraftPersistence<T extends IUnmodifiableNominable> extends AbstractXmlPersistence<T> implements IMinecraftPersistence<T> {
	private IDefaultContent defaultContent;

	protected AbstractMinecraftPersistence(IDefaultContent defaultContent) {
		this(Plateform.ROOT, defaultContent);
	}

	protected AbstractMinecraftPersistence(Path path, IDefaultContent defaultContent) {
		super(path);
		this.defaultContent = defaultContent;
	}

	@Override
	public IDefaultContent getDefaultContent() {
		return defaultContent;
	}

	protected void setInternalPath(Path path) {
		checkPath(path);
		super.setInternalPath(path);
	}

	private void checkPath(Path path) {
		if (!path.startsWith(Plateform.ROOT))
			throw new IllegalPathException(path);
	}
}
