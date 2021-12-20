package fr.pederobien.minecraft.game.platform.interfaces.editions;

import fr.pederobien.minecraft.game.platform.Platform;
import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.messagecode.ICodeSender;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftNotificationCenter;

public interface IPlateformCodeSender extends ICodeSender {

	@Override
	public default IMinecraftNotificationCenter getNotificationCenter() {
		return Platform.getNotificationCenter();
	}
}
