package fr.pederobien.minecraft.game.platform.interfaces.element;

import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface INominable extends IUnmodifiableNominable {

	/**
	 * Set the name of this element.
	 * 
	 * @param name The new name of the element.
	 */
	void setName(String name);
}
