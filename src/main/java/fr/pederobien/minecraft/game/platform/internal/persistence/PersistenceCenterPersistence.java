package fr.pederobien.minecraft.game.platform.internal.persistence;

import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pederobien.minecraft.game.platform.impl.element.persistence.AbstractMinecraftPersistence;
import fr.pederobien.minecraft.game.platform.internal.IPersistenceCenter;
import fr.pederobien.minecraft.game.platform.internal.persistence.loaders.PersistenceCenterLoaderV10;
import fr.pederobien.minecraft.game.platform.utils.Platform;

public class PersistenceCenterPersistence extends AbstractMinecraftPersistence<IPersistenceCenter> {
	private static final String ROOT_XML_DOCUMENT = "register";

	public PersistenceCenterPersistence(IPersistenceCenter persistenceRegister) {
		super(Platform.ROOT.resolve("Internal"), "register");
		register(new PersistenceCenterLoaderV10(persistenceRegister));
		set(persistenceRegister);
	}

	@Override
	public void saveDefault() {
		save();
	}

	@Override
	public boolean save() {
		Document doc = newDocument();
		doc.setXmlStandalone(true);

		Element root = createElement(doc, ROOT_XML_DOCUMENT);
		doc.appendChild(root);

		Element version = createElement(doc, VERSION);
		version.appendChild(doc.createTextNode("" + getVersion()));
		root.appendChild(version);

		Element persistencies = createElement(doc, PersistenceXmlTag.PERSISTENCIES);
		for (Map.Entry<String, Double> entry : get().getPersistencies().entrySet()) {
			Element persistence = createElement(doc, PersistenceXmlTag.PERSISTENCE);
			Element className = createElement(doc, PersistenceXmlTag.CLASS);
			className.appendChild(doc.createTextNode(entry.getKey()));
			persistence.appendChild(className);
			Element persistenceVersion = createElement(doc, PersistenceXmlTag.VERSION);
			persistenceVersion.appendChild(doc.createTextNode(entry.getValue().toString()));
			persistence.appendChild(persistenceVersion);
			persistencies.appendChild(persistence);
		}
		root.appendChild(persistencies);

		saveDocument(doc, get().getName());
		return true;
	}
}
