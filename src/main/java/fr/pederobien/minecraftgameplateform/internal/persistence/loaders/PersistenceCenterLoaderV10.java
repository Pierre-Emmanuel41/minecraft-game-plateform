package fr.pederobien.minecraftgameplateform.internal.persistence.loaders;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fr.pederobien.minecraftgameplateform.internal.IPersistenceCenter;
import fr.pederobien.minecraftgameplateform.internal.persistence.PersistenceXmlTag;
import fr.pederobien.persistence.interfaces.xml.IXmlPersistenceLoader;

public class PersistenceCenterLoaderV10 extends AbstractPersistenceCenterLoader {

	public PersistenceCenterLoaderV10(IPersistenceCenter elt) {
		super(1.0, elt);
	}

	@Override
	public IXmlPersistenceLoader<IPersistenceCenter> load(Element root) {
		createNewElement();

		NodeList persistencies = getElementsByTagName(root, PersistenceXmlTag.PERSISTENCE);
		for (int i = 0; i < persistencies.getLength(); i++) {
			Element persistence = (Element) persistencies.item(i);
			Element className = (Element) getElementsByTagName(persistence, PersistenceXmlTag.CLASS).item(0);
			Element version = (Element) getElementsByTagName(persistence, PersistenceXmlTag.VERSION).item(0);
			get().register(className.getChildNodes().item(0).getNodeValue(), getDoubleNodeValue(version.getChildNodes().item(0)));
		}
		return this;
	}
}
