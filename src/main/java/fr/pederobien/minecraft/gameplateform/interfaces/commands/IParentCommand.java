package fr.pederobien.minecraft.gameplateform.interfaces.commands;

import fr.pederobien.minecraft.gameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface IParentCommand<T extends IUnmodifiableNominable> extends ICommand {

	/**
	 * @return The parent that contains all registered editions for this command.
	 */
	IParentPersistenceEdition<T> getParent();
}
