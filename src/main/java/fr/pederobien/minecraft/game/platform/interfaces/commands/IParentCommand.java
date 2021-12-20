package fr.pederobien.minecraft.game.platform.interfaces.commands;

import fr.pederobien.minecraft.game.platform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public interface IParentCommand<T extends IUnmodifiableNominable> extends ICommand {

	/**
	 * @return The parent that contains all registered editions for this command.
	 */
	IParentPersistenceEdition<T> getParent();
}
