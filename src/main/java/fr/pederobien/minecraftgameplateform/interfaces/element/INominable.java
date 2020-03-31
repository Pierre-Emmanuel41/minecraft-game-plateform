package fr.pederobien.minecraftgameplateform.interfaces.element;

import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public interface INominable extends IUnmodifiableNominable {

	/**
	 * Set the name of this element.
	 * 
	 * @param name The new name of the element.
	 */
	void setName(String name);
}
