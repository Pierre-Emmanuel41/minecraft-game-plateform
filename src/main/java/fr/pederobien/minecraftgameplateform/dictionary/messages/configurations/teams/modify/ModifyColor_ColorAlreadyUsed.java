package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyColor_ColorAlreadyUsed extends AbstractDynamicMessage {
	/**
	 * Message in French when the new colour is already used by another team.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the new colour is already used by another team.
	 */
	public static final IMessage ENGLISH = new English();

	public ModifyColor_ColorAlreadyUsed() {
		super(ETeamModifyMessageCode.MODIFY_COLOR__COLOR_ALREADY_USED);
	}

	private static class French extends ModifyColor_ColorAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "Impossible de modifier la couleur de l'�quipe " + args[0] + ", la couleur " + args[1] + " est d�j� utilis�e par l'�quipe " + args[2];
		}
	}

	private static class English extends ModifyColor_ColorAlreadyUsed {
		@Override
		public String getMessage(String... args) {
			return "Cannot modify the color of team " + args[0] + ", the color " + args[1] + " is already used by team " + args[2];
		}
	}
}