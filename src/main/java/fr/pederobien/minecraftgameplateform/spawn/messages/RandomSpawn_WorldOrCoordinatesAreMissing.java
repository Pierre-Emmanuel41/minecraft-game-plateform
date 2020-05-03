package fr.pederobien.minecraftgameplateform.spawn.messages;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;

public class RandomSpawn_WorldOrCoordinatesAreMissing extends AbstractNotDynamicMessage {

	public RandomSpawn_WorldOrCoordinatesAreMissing(String message) {
		super(ESpawnMessageCode.RANDOM_SPAWN__WORLD_OR_COORDINATES_ARE_MISSING, message);
		ESpawnMessages.FRENCH.add(new French());
		ESpawnMessages.ENGLISH.add(new English());
	}

	private static class French extends RandomSpawn_WorldOrCoordinatesAreMissing {
		public French() {
			super("Impossible de charger aléatoirement un spawn, il manque le nom du monde ou les coordonnées du centre");
		}
	}

	private static class English extends RandomSpawn_WorldOrCoordinatesAreMissing {
		public English() {
			super("Cannot launch randomly a spawn, world's name or center's coordinates are missing");
		}
	}
}
