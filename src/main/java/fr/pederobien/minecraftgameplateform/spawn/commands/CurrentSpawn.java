package fr.pederobien.minecraftgameplateform.spawn.commands;

import fr.pederobien.minecraftgameplateform.commands.configurations.CommonCurrent;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class CurrentSpawn extends CommonCurrent<ISpawn> {

	protected CurrentSpawn() {
		super(ESpawnMessageCode.CURRENT_SPAWN__EXPLANATION, ESpawnMessageCode.CURRENT_SPAWN__ON_CURRENT);
	}
}
