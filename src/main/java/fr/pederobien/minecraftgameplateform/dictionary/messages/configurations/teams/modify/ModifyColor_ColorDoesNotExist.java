package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyColor_ColorDoesNotExist extends AbstractDynamicMessage {
	/**
	 * Message in French when the new color's name does not correspond to an existing colour.
	 */
	public static final IMessage FRENCH = new French();
	/**
	 * Message in English when the new color's name does not correspond to an existing colour.
	 */
	public static final IMessage ENGLISH = new English();

	public ModifyColor_ColorDoesNotExist() {
		super(ETeamModifyMessageCode.MODIFY_COLOR__COLOR_DOES_NOT_EXIST);
	}

	private static class French extends ModifyColor_ColorDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible de modifier la couleur de l'équipe " + args[0] + ", la couleur \"" + args[1] + "\" n'existe pas";
		}
	}

	private static class English extends ModifyColor_ColorDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot modify the color of team " + args[0] + ", the color \"" + args[1] + "\" n'existe pas";
		}
	}
}
