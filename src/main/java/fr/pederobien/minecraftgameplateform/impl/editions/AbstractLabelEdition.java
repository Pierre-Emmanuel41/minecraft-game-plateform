package fr.pederobien.minecraftgameplateform.impl.editions;

import java.util.List;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
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
	protected void setNewEditionAvailable(ILabel label) {
		List<IMapPersistenceEdition<T>> descendants = getParent().getChildrenByLabelName(label.getLabel());
		for (IMapPersistenceEdition<T> descendant : descendants)
			descendant.setAvailable(true);
	}

	/**
	 * Find all descendants of the parent for each label in the given array and set their availability to true.
	 * 
	 * @param labels An array to find different parent's descendants.
	 * 
	 * @see AbstractMapPersistenceEdition#setNewEditionAvailable(String)
	 */
	protected void setNewEditionsAvailable(ILabel... labels) {
		for (ILabel label : labels)
			setNewEditionAvailable(label);
	}

	/**
	 * Find all descendants of the parent whose label match on the given label and set their availability to false.
	 * 
	 * @param label The name of the label to match on.
	 * 
	 * @see IParentPersistenceEdition#getChildrenByLabelName(String)
	 * @see #setAvailable(boolean)
	 */
	protected void setNewEditionNotAvailable(ILabel label) {
		List<IMapPersistenceEdition<T>> descendants = getParent().getChildrenByLabelName(label.getLabel());
		for (IMapPersistenceEdition<T> descendant : descendants)
			descendant.setModifiable(true).setAvailable(false);
	}

	/**
	 * Find all descendants of the parent for each label in the given array and set their availability to false.
	 * 
	 * @param labels An array to find different parent's descendants.
	 * 
	 * @see AbstractMapPersistenceEdition#setNewEditionAvailable(String)
	 */
	protected void setNewEditionsNotAvailable(ILabel... labels) {
		for (ILabel label : labels)
			setNewEditionAvailable(label);
	}

}
