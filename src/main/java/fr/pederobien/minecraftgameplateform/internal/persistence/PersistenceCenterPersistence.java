package fr.pederobien.minecraftgameplateform.internal.persistence;

import java.nio.file.Paths;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pederobien.minecraftgameplateform.impl.element.persistence.AbstractDefaultContent;
import fr.pederobien.minecraftgameplateform.impl.element.persistence.xml.AbstractXmlPersistence;
import fr.pederobien.minecraftgameplateform.internal.IPersistenceCenter;
import fr.pederobien.minecraftgameplateform.internal.persistence.loaders.PersistenceCenterLoaderV10;

public class PersistenceCenterPersistence extends AbstractXmlPersistence<IPersistenceCenter> {
	private static final String ROOT_XML_DOCUMENT = "register";

	public PersistenceCenterPersistence(IPersistenceCenter persistenceRegister) {
		super(ROOT.resolve(Paths.get("Internal")), new PersistenceRegisterDefaultContent());
		register(new PersistenceCenterLoaderV10(persistenceRegister));
		set(persistenceRegister);
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

	private static class PersistenceRegisterDefaultContent extends AbstractDefaultContent {

		public PersistenceRegisterDefaultContent() {
			super("register");
		}

		@Override
		public String getDefaultContent() {
			return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "<register/>\r\n" + "  <version>1.0</version>\r\n" + "</register>";
		}
	}
}
