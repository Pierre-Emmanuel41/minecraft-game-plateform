package fr.pederobien.minecraftgameplateform.interfaces.editions;

import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.IGenericParentEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public interface IParentPersistenceEdition<T extends IUnmodifiableNominable>
		extends IGenericParentEdition<IMessageCode, T, IParentPersistenceEdition<T>>, IPersistenceEdition<T> {

}
