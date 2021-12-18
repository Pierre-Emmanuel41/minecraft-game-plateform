package fr.pederobien.minecraft.gameplateform.interfaces.editions;

import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.messagecode.IMessageCodeMapEdition;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface IMapPersistenceEdition<T extends IUnmodifiableNominable>
		extends IMessageCodeMapEdition<T, IParentPersistenceEdition<T>, IMapPersistenceEdition<T>>, IPlateformCodeSender {

}
