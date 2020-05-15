package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class ModifyColor_ColorDoesNotExist extends AbstractDynamicMessage {
	public static final IMinecraftMessage FRENCH = new French();
	public static final IMinecraftMessage ENGLISH = new English();

	public ModifyColor_ColorDoesNotExist() {
		super(ETeamModifyMessageCode.MODIFY_COLOR__COLOR_DOES_NOT_EXIST);
	}

	private static class French extends ModifyColor_ColorDoesNotExist {
		@Override
		public String getMessage(Object... args) {
			return "Impossible de modifier la couleur de l'équipe " + args[0] + ", la couleur \"" + args[1] + "\" n'existe pas";
		}
	}

	private static class English extends ModifyColor_ColorDoesNotExist {
		@Override
		public String getMessage(Object... args) {
			return "Cannot modify the color of team " + args[0] + ", the color \"" + args[1] + "\" n'existe pas";
		}
	}
}
