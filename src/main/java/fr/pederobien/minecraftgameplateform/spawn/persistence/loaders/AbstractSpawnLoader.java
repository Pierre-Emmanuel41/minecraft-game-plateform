package fr.pederobien.minecraftgameplateform.spawn.persistence.loaders;

import org.w3c.dom.Element;

import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.spawn.Spawn;
import fr.pederobien.minecraftgameplateform.spawn.persistence.SpawnXmlTag;
import fr.pederobien.persistence.impl.xml.AbstractXmlPersistenceLoader;
import fr.pederobien.persistence.interfaces.xml.IXmlPersistenceLoader;

public abstract class AbstractSpawnLoader extends AbstractXmlPersistenceLoader<ISpawn> implements IXmlPersistenceLoader<ISpawn> {

	protected AbstractSpawnLoader(Double version) {
		super(version, new Spawn("DefaultSpawn"));
	}

	protected String getXCoordinates(Element element) {
		return getStringAttribute(element, SpawnXmlTag.X_COORDINATES);
	}

	protected String getYCoordinates(Element element) {
		return getStringAttribute(element, SpawnXmlTag.Y_COORDINATES);
	}

	protected String getZCoordinates(Element element) {
		return getStringAttribute(element, SpawnXmlTag.Z_COORDINATES);
	}
}
