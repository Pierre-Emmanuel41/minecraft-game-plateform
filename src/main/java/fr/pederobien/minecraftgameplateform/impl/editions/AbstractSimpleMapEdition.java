package fr.pederobien.minecraftgameplateform.impl.editions;

import fr.pederobien.minecraftdevelopmenttoolkit.impl.messagecode.AbstractMessageCodeSimpleMapEdition;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class AbstractSimpleMapEdition extends AbstractMessageCodeSimpleMapEdition {

	public AbstractSimpleMapEdition(String label, IMinecraftMessageCode explanation) {
		super(label, explanation);
	}

	@Override
	public IMinecraftNotificationCenter getNotificationCenter() {
		return Plateform.getNotificationCenter();
	}
}
