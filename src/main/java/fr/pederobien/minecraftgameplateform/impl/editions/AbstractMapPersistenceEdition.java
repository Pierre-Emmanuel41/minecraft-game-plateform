package fr.pederobien.minecraftgameplateform.impl.editions;

import fr.pederobien.minecraftdevelopmenttoolkit.impl.AbstractGenericMapEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public class AbstractMapPersistenceEdition<T extends IUnmodifiableNominable> extends AbstractGenericMapEdition<IMessageCode, T, IParentPersistenceEdition<T>>
		implements IMapPersistenceEdition<T> {

	public AbstractMapPersistenceEdition(String label, IMessageCode explanation) {
		super(label, explanation);
	}
}
