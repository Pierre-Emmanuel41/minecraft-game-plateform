package fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.spawn;

import fr.pederobien.minecraftgameplateform.dictionary.EMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractMessage;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessage;

public class SpawnParentExplanation extends AbstractMessage {
	public static final IMessage FRENCH = new French();
	public static final IMessage ENGLISH = new English();

	public SpawnParentExplanation() {
		super(EMessageCode.SPAWN_PARENT_EXPLANATION);
	}

	@Override
	public String getMessage(String... args) {
		return null;
	}

	private static class French extends SpawnParentExplanation {

		@Override
		public String getMessage(String... args) {
			return "Pour configurer un spawn";
		}
	}

	private static class English extends SpawnParentExplanation {

		@Override
		public String getMessage(String... args) {
			return "To configure a spawn";
		}
	}
}
