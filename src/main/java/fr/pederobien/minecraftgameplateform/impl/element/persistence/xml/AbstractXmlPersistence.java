package fr.pederobien.minecraftgameplateform.impl.element.persistence.xml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import fr.pederobien.minecraftgameplateform.impl.element.persistence.AbstractLoadersPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IDefaultContent;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.xml.IXmlPersistenceLoader;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public abstract class AbstractXmlPersistence<T extends IUnmodifiableNominable> extends AbstractLoadersPersistence<T, IXmlPersistenceLoader<T>> {
	private static final String EXTENSION = ".xml";
	protected static final String VERSION = "version";
	private DocumentBuilder builder;
	private T elt;

	protected AbstractXmlPersistence(Path path, IDefaultContent defaultContent) {
		super(path, defaultContent);

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public IPersistence<T> load(String name) throws FileNotFoundException {
		try {
			Document doc = parse(name);
			Element root = doc.getDocumentElement();
			Node version = root.getElementsByTagName(VERSION).item(0);

			// First: get the loader associated to the version found in the xml file.
			// Second: call the method load(Node root) to create a object of type T with properties specified in the xml file.
			// Third: set the object coming from the loader.
			set(getLoaders().get(Double.parseDouble(version.getChildNodes().item(0).getNodeValue())).load(root).get());
		} catch (IOException e) {

		}
		return this;
	}

	@Override
	public T get() {
		return elt;
	}

	@Override
	public IPersistence<T> set(T elt) {
		this.elt = elt;
		return this;
	}

	@Override
	public boolean exist(String name) {
		return getAbsolutePath(name).toFile().exists();
	}

	@Override
	public boolean delete(String name) {
		return getAbsolutePath(name).toFile().delete();
	}

	@Override
	public List<String> list() {
		String[] list = getPath().toFile().list();
		List<String> names = new ArrayList<String>();
		for (String name : list)
			names.add(name.substring(0, name.indexOf(EXTENSION)));
		return names;
	}

	@Override
	public Path getAbsolutePath(String name) {
		return getPath().resolve(Paths.get(name + EXTENSION));
	}

	/**
	 * @return The absolute path associated to the object this persistence managed. It is equivalent to call
	 *         {@link #getAbsolutePath(String)} with parameter path equals the name of the object returned by {@link #get()}
	 */
	protected Path getAbsolutePath() {
		return getAbsolutePath(get().getName());
	}

	/**
	 * Obtain a new instance of a DOM {@link Document} object to build a DOM tree with.
	 *
	 * @return A new instance of a DOM Document object.
	 */
	protected Document newDocument() {
		return builder.newDocument();
	}

	/**
	 * Save the given document.
	 * 
	 * @param doc  The document to save.
	 * @param name The name of the file containing xml data.
	 * @return True if the document has been correctly saved, false otherwise.
	 */
	protected boolean saveDocument(Document doc, String name) {
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.transform(new DOMSource(doc), new StreamResult(getAbsolutePath(name).toFile()));
			return true;
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return false;
	}

	private Document parse(String name) throws IOException {
		try {
			return builder.parse(getAbsolutePath(name).toFile());
		} catch (SAXException e) {
			e.printStackTrace();
		}
		return null;
	}
}
