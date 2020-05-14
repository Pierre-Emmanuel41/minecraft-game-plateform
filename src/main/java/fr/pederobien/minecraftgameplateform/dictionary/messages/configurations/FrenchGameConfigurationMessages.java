package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public enum FrenchGameConfigurationMessages {
	AS_CURRENT_EXPLANATION(AsCurrent_Explanation.FRENCH),

	AS_CURRENT_GAME_STYLE_DEFINED(AsCurrent_GameStyleDefined.FRENCH),

	LOAD_STYLE_DOES_NOT_EXIST(CommonLoad_StyleDoesNotExist.FRENCH),

	SCOREBOARD_REFRESH_EXPLANATION(ScoreboardRefresh_Explanation.FRENCH),

	SCOREBOARD_REFRESH_ON_TAB_COMPLETE(ScoreboardRefresh_OnTabComplete.FRENCH),

	SCOREBOARD_REFRESH_NEGATIVE_TIC_NUMBER(ScoreboardRefresh_NegativeTicsNumber.FRENCH),

	SCOREBOARD_REFRESH_TICS_NUMBER_IS_MISSING(ScoreboardRefresh_TicsNumberIsMissing.FRENCH),

	SCOREBOARD_REFRESH_ONE_TIC_DEFINED(ScoreboardRefresh_OneTicDefined.FRENCH),

	SCOREBOARD_REFRESH_SEVERAL_TICS_DEFINED(ScoreboardRefresh_SeveralTicsDefined.FRENCH);

	private IMinecraftMessage source;

	private FrenchGameConfigurationMessages(IMinecraftMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (FrenchGameConfigurationMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMinecraftMessage getSource() {
		return source;
	}
}
