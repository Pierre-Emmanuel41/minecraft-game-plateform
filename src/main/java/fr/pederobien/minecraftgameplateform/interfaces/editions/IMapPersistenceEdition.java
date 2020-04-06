package fr.pederobien.minecraftgameplateform.interfaces.editions;

import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.IGenericMapEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public interface IMapPersistenceEdition<T extends IUnmodifiableNominable> extends IGenericMapEdition<IMessageCode, T, IParentPersistenceEdition<T>> {

}
