package fr.pederobien.minecraftgameplateform.worldstructure.commands;

import org.bukkit.block.Block;

import fr.pederobien.minecraftgameplateform.impl.editions.AbstractMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;

public abstract class AbstractWorldStructureEdition<T extends IWorldStructure> extends AbstractMapPersistenceEdition<T> {

	protected AbstractWorldStructureEdition(String label, IMessageCode explanation) {
		super(label, explanation);
	}

	/**
	 * @return The center of this world structure.
	 * 
	 * @see IWorldStructure#getCenter()
	 */
	protected Block getCenter() {
		return get().getCenter();
	}
}
