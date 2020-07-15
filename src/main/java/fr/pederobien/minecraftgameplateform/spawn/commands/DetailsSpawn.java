package fr.pederobien.minecraftgameplateform.spawn.commands;

import fr.pederobien.minecraftgameplateform.commands.common.CommonDetails;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class DetailsSpawn extends CommonDetails<ISpawn> {

	protected DetailsSpawn() {
		super(ESpawnMessageCode.DETAILS_SPAWN__EXPLANATION, ESpawnMessageCode.DETAILS_SPAWN__ON_DETAILS);
	}
}
