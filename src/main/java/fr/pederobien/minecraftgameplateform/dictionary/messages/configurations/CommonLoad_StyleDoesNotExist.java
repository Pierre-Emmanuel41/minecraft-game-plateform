package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.minecraftgameplateform.dictionary.messages.AbstractDynamicMessage;

public class CommonLoad_StyleDoesNotExist extends AbstractDynamicMessage {

	public CommonLoad_StyleDoesNotExist() {
		super(EGameConfigurationMessageCode.COMMON_LOAD__CONFIGURATION_DOES_NOT_EXIST);
		EGameConfigurationMessages.FRENCH.add(new French());
		EGameConfigurationMessages.ENGLISH.add(new English());
	}

	private static class French extends CommonLoad_StyleDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Impossible de charger la configuration " + args[0] + ", cette configuration n'existe pas";
		}
	}

	private static class English extends CommonLoad_StyleDoesNotExist {
		@Override
		public String getMessage(String... args) {
			return "Cannot load configuration " + args[0] + ", this configuration does not exist";
		}
	}
}
