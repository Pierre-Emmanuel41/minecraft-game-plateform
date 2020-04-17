package fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractNotDynamicMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class RandomSpawn_WorldOrCoordinatesAreMissing extends AbstractNotDynamicMessage {
	/**
	 * Message in French when the world's name or the center's coordinates are missing to launch randomly a spawn.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the world's name or the center's coordinates are missing to launch randomly a spawn.
	 */
	public static final IMessage ENGLISH = new English();

	public RandomSpawn_WorldOrCoordinatesAreMissing(String message) {
		super(ESpawnMessageCode.RANDOM_SPAWN__WORLD_OR_COORDINATES_ARE_MISSING, message);
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
