package fr.pederobien.minecraftgameplateform.border.commands;

import fr.pederobien.minecraftgameplateform.commands.common.CommonCurrent;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;

public class CurrentBorder extends CommonCurrent<IBorderConfiguration> {

	protected CurrentBorder() {
		super(EBorderMessageCode.CURRENT_BORDER__EXPLANATION, EBorderMessageCode.CURRENT_BORDER__ON_CURRENT);
	}
}
