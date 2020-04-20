package fr.pederobien.minecraftgameplateform.internal.persistence.loaders;

import fr.pederobien.minecraftgameplateform.impl.element.persistence.xml.AbstractXmlPersistenceLoader;
import fr.pederobien.minecraftgameplateform.internal.IPersistenceCenter;

public abstract class AbstractPersistenceCenterLoader extends AbstractXmlPersistenceLoader<IPersistenceCenter> {

	protected AbstractPersistenceCenterLoader(Double version, IPersistenceCenter elt) {
		super(version, elt);
	}
}
