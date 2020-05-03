package fr.pederobien.minecraftgameplateform.spawn.commands;

import fr.pederobien.minecraftgameplateform.commands.common.CommonCurrent;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.spawn.messages.ESpawnMessageCode;

public class CurrentSpawn extends CommonCurrent<ISpawn> {

	protected CurrentSpawn() {
		super(ESpawnMessageCode.CURRENT_SPAWN__EXPLANATION, ESpawnMessageCode.CURRENT_SPAWN__ON_CURRENT);
	}
}
