package fr.pederobien.minecraftgameplateform.worldstructure.spawn.persistence.loaders;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import fr.pederobien.minecraftgameplateform.impl.element.persistence.AbstractPersistenceLoader;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.xml.IXmlPersistenceLoader;
import fr.pederobien.minecraftgameplateform.worldstructure.spawn.Spawn;
import fr.pederobien.minecraftgameplateform.worldstructure.spawn.persistence.SpawnXmlTag;

public abstract class AbstractSpawnLoader extends AbstractPersistenceLoader<ISpawn> implements IXmlPersistenceLoader<ISpawn> {

	protected AbstractSpawnLoader(Double version) {
		super(version, new Spawn("DefaultSpawn"));
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

	protected String getXCoordinates(Element element) {
		return getStringAttribute(element, SpawnXmlTag.X_COORDINATES);
	}

	protected String getYCoordinates(Element element) {
		return getStringAttribute(element, SpawnXmlTag.Y_COORDINATES);
	}

	protected String getZCoordinates(Element element) {
		return getStringAttribute(element, SpawnXmlTag.Z_COORDINATES);
	}
}
