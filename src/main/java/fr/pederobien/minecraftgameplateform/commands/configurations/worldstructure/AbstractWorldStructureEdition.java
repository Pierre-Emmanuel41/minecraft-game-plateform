package fr.pederobien.minecraftgameplateform.commands.configurations.worldstructure;

import org.bukkit.block.Block;

import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;

public abstract class AbstractWorldStructureEdition<T extends IWorldStructure> extends AbstractLabelEdition<T> {

	protected AbstractWorldStructureEdition(ILabel label, IMessageCode explanation) {
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
