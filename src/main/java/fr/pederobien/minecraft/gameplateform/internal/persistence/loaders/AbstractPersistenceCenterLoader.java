package fr.pederobien.minecraft.gameplateform.internal.persistence.loaders;

import fr.pederobien.minecraft.gameplateform.internal.IPersistenceCenter;
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
