package fr.pederobien.minecraftgameplateform.interfaces.editions;

import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.messagecode.IMessageCodeMapEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public interface IMapPersistenceEdition<T extends IUnmodifiableNominable> extends IMessageCodeMapEdition<T, IParentPersistenceEdition<T>, IMapPersistenceEdition<T>> {

}
