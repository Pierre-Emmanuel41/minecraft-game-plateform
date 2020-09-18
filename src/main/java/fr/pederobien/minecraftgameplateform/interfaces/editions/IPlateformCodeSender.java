package fr.pederobien.minecraftgameplateform.interfaces.editions;

import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.messagecode.ICodeSender;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public interface IPlateformCodeSender extends ICodeSender {

	@Override
	public default IMinecraftNotificationCenter getNotificationCenter() {
		return Plateform.getNotificationCenter();
	}
}
