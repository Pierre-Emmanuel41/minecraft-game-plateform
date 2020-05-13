package fr.pederobien.minecraftgameplateform.border.persistence.loaders;

import fr.pederobien.minecraftgameplateform.border.BorderConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;
import fr.pederobien.persistence.impl.xml.AbstractXmlPersistenceLoader;

public abstract class AbstractBorderLoader extends AbstractXmlPersistenceLoader<IBorderConfiguration> {

	protected AbstractBorderLoader(Double version) {
		super(version, new BorderConfiguration("DefaultBorder"));
	}
}
