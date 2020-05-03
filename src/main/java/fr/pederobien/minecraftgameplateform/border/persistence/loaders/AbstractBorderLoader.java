package fr.pederobien.minecraftgameplateform.border.persistence.loaders;

import fr.pederobien.minecraftgameplateform.border.BorderConfiguration;
import fr.pederobien.minecraftgameplateform.impl.element.persistence.xml.AbstractXmlPersistenceLoader;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;

public abstract class AbstractBorderLoader extends AbstractXmlPersistenceLoader<IBorderConfiguration> {

	protected AbstractBorderLoader(Double version) {
		super(version, new BorderConfiguration("DefaultBorder"));
	}
}
