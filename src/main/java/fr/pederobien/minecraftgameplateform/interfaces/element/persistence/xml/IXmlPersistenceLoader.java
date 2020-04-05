package fr.pederobien.minecraftgameplateform.interfaces.element.persistence.xml;

import org.w3c.dom.Element;

import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistenceLoader;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public interface IXmlPersistenceLoader<T extends IUnmodifiableNominable> extends IPersistenceLoader<T> {

	/**
	 * Load data coming from the given root.
	 * 
	 * @param root The node that correspond to the root of an xml document.
	 * 
	 * @return this loader.
	 */
	IXmlPersistenceLoader<T> load(Element root);
}
