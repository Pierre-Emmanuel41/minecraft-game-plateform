package fr.pederobien.minecraftgameplateform.internal.persistence.loaders;

import fr.pederobien.minecraftgameplateform.internal.IPersistenceCenter;
import fr.pederobien.persistence.impl.xml.AbstractXmlPersistenceLoader;

public abstract class AbstractPersistenceCenterLoader extends AbstractXmlPersistenceLoader<IPersistenceCenter> {

	protected AbstractPersistenceCenterLoader(Double version, IPersistenceCenter elt) {
		super(version, elt);
	}
}
