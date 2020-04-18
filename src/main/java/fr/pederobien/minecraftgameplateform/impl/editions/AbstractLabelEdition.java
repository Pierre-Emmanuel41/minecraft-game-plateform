package fr.pederobien.minecraftgameplateform.impl.editions;

import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public abstract class AbstractLabelEdition<T extends IUnmodifiableNominable> extends AbstractMapPersistenceEdition<T> {

	protected AbstractLabelEdition(ILabel label, IMessageCode explanation) {
		super(label.getLabel(), explanation);
	}

	/**
	 * Find all descendants of the parent whose label match on the given label and set their availability to true.
	 * 
	 * @param label The name of the label to match on.
	 * 
	 * @see IParentPersistenceEdition#getChildrenByLabelName(String)
	 * @see #setAvailable(boolean)
	 */
	protected void setAvailableLabelEdition(ILabel label) {
		setAvailableEdition(label.getLabel());
	}

	/**
	 * Find all descendants of the parent for each label in the given array and set their availability to true.
	 * 
	 * @param labels An array to find different parent's descendants.
	 * 
	 * @see AbstractMapPersistenceEdition#setAvailableEdition(String)
	 */
	protected void setAvailableLabelEditions(ILabel... labels) {
		for (ILabel label : labels)
			setAvailableLabelEdition(label);
	}

	/**
	 * Find all descendants of the parent whose label match on the given label and set their availability to false.
	 * 
	 * @param label The name of the label to match on.
	 * 
	 * @see IParentPersistenceEdition#getChildrenByLabelName(String)
	 * @see #setAvailable(boolean)
	 */
	protected void setNotAvailableLabelEdition(ILabel label) {
		setNotAvailableEdition(label.getLabel());
	}

	/**
	 * Find all descendants of the parent for each label in the given array and set their availability to false.
	 * 
	 * @param labels An array to find different parent's descendants.
	 * 
	 * @see AbstractMapPersistenceEdition#setAvailableEdition(String)
	 */
	protected void setNotAvailableLabelEditions(ILabel... labels) {
		for (ILabel label : labels)
			setNotAvailableLabelEdition(label);
	}
}
