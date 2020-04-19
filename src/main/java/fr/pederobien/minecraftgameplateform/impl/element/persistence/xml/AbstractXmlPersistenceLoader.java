package fr.pederobien.minecraftgameplateform.impl.element.persistence.xml;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fr.pederobien.minecraftgameplateform.impl.element.persistence.AbstractPersistenceLoader;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.xml.IXmlPersistenceLoader;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public abstract class AbstractXmlPersistenceLoader<T extends IUnmodifiableNominable> extends AbstractPersistenceLoader<T> implements IXmlPersistenceLoader<T> {

	protected AbstractXmlPersistenceLoader(Double version, T elt) {
		super(version, elt);
	}

	/**
	 * Returns a <code>NodeList</code> of all descendant <code>Elements</code> with a given tag name, in document order.
	 * 
	 * @param element The element used to search its descendant.
	 * @param name    The name of the tag to match on. The special value "*" matches all tags.
	 * 
	 * @return A list of matching <code>Element</code> nodes.
	 */
	protected NodeList getElementsByTagName(Element element, Object name) {
		return element.getElementsByTagName(name.toString());
	}

	/**
	 * Retrieves an attribute value by name.
	 * 
	 * @param element The element used to search attributes.
	 * @param name    The name of the attribute to retrieve.
	 * 
	 * @return The <code>Attr</code> value as a string, or the empty string if that attribute does not have a specified or default
	 *         value.
	 */
	protected String getStringAttribute(Element element, Object name) {
		return element.getAttribute(name.toString());
	}

	/**
	 * Convert the result returned by {@link #getStringAttribute(Element, Object)} into an integer.
	 * 
	 * @param element The element used to search attributes.
	 * @param name    The name of the attribute to retrieve.
	 * 
	 * @return An integer.
	 */
	protected int getIntAttribute(Element element, Object name) {
		return toInt(getStringAttribute(element, name));
	}
}
