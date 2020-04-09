package fr.pederobien.minecraftgameplateform.impl.editions;

import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public abstract class AbstractLabelEdition<T extends IUnmodifiableNominable> extends AbstractMapPersistenceEdition<T> {

	protected AbstractLabelEdition(ILabel label, IMessageCode explanation) {
		super(label.getLabel(), explanation);
	}
}
