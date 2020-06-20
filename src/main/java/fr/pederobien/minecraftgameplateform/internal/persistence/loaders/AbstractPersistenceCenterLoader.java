package fr.pederobien.minecraftgameplateform.internal.persistence.loaders;

import fr.pederobien.minecraftgameplateform.internal.IPersistenceCenter;
import fr.pederobien.persistence.impl.xml.AbstractXmlPersistenceLoader;

public abstract class AbstractPersistenceCenterLoader extends AbstractXmlPersistenceLoader<IPersistenceCenter> {
	private IPersistenceCenter persistence;

	protected AbstractPersistenceCenterLoader(Double version, IPersistenceCenter elt) {
		super(version);
		this.persistence = elt;
	}

	@Override
	protected IPersistenceCenter create() {
		return persistence;
	}
}
