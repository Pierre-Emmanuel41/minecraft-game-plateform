package fr.pederobien.minecraft.game.platform.impl.element.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

import org.w3c.dom.Document;

import fr.pederobien.minecraft.game.platform.GamePlatformPlugin;
import fr.pederobien.minecraft.game.platform.Platform;
import fr.pederobien.minecraft.game.platform.exceptions.persistence.IllegalPathException;
import fr.pederobien.minecraft.game.platform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.persistence.impl.xml.AbstractXmlPersistence;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public abstract class AbstractMinecraftPersistence<T extends IUnmodifiableNominable> extends AbstractXmlPersistence<T> implements IMinecraftPersistence<T> {
	private String defaultName;

	protected AbstractMinecraftPersistence(String defaultName) {
		this(Platform.ROOT, defaultName);
	}

	protected AbstractMinecraftPersistence(Path path, String defaultName) {
		super(path);
		this.defaultName = defaultName;
	}

	@Override
	protected Document createDoc(Object... objects) throws IOException {
		return parseFromFileName((String) objects[0]);
	}

	@Override
	public String getDefault() {
		return defaultName;
	}

	@Override
	public void setPath(Path path) {
		checkPath(path);
		super.setPath(path);
	}

	@Override
	public void update() {
		list().forEach(name -> {
			GamePlatformPlugin.instance().getLogger().info("Upgrading " + name);
			try {
				load(name);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			save();
		});
		set(null);
	}

	private void checkPath(Path path) {
		if (!path.startsWith(Platform.ROOT))
			throw new IllegalPathException(path);
	}
}
