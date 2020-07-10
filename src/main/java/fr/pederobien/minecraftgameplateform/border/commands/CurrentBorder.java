package fr.pederobien.minecraftgameplateform.border.commands;

import fr.pederobien.minecraftgameplateform.border.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.commands.common.CommonCurrent;

public class CurrentBorder extends CommonCurrent<IBorderConfiguration> {

	protected CurrentBorder() {
		super(EBorderMessageCode.CURRENT_BORDER__EXPLANATION, EBorderMessageCode.CURRENT_BORDER__ON_CURRENT);
	}
}
