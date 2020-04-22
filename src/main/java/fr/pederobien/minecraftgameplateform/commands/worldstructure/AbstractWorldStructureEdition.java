package fr.pederobien.minecraftgameplateform.commands.worldstructure;

import fr.pederobien.minecraftdictionary.interfaces.IMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldStructure;

public abstract class AbstractWorldStructureEdition<T extends IWorldStructure> extends AbstractLabelEdition<T> {

	protected AbstractWorldStructureEdition(ILabel label, IMessageCode explanation) {
		super(label, explanation);
	}
}
