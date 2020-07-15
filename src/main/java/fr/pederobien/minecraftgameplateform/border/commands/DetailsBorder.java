package fr.pederobien.minecraftgameplateform.border.commands;

import fr.pederobien.minecraftgameplateform.border.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.commands.common.CommonDetails;

public class DetailsBorder extends CommonDetails<IBorderConfiguration> {

	protected DetailsBorder() {
		super(EBorderMessageCode.DETAILS_BORDER__EXPLANATION, EBorderMessageCode.DETAILS_BORDER__ON_DETAILS);
	}
}
