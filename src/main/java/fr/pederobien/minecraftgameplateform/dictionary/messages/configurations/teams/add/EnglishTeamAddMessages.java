package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum EnglishTeamAddMessages {
	ADD_TEAM_EXPLANATION(AddTeam_Explanation.ENGLISH),

	ADD_TEAM_TEAM_NAME_IS_MISSING(AddTeam_TeamNameIsMissing.ENGLISH),

	ADD_TEAM_COLOR_NAME_IS_MISSING(AddTeam_ColorNameIsMissing.ENGLISH),

	ADD_TEAM_COLOR_DOES_NOT_EXIST(AddTeam_ColorDoesNotExist.ENGLISH),

	ADD_TEAM_TEAM_NAME_FORBIDDEEN(AddTeam_TeamNameForbidden.ENGLISH),

	ADD_TEAM_TEAM_NAME_ALREADY_USED(AddTeam_TeamNameAlreadyUsed.ENGLISH),

	ADD_TEAM_COLOR_ALREADY_USED(AddTeam_ColorAlreadyUsed.ENGLISH),

	ADD_TEAM_TEAM_ADDED(AddTeam_TeamAdded.ENGLISH),

	ADD_PLAYER_EXPLANATION(AddPlayer_Explanation.ENGLISH),

	ADD_PLAYER_TEAM_NAME_IS_MISSING(AddPlayer_TeamNameIsMissing.ENGLISH),

	ADD_PLAYER_TEAM_DOES_NOT_EXIST(AddPlayer_TeamDoesNotExist.ENGLISH),

	ADD_PLAYER_PLAYER_ALREADY_REGISTERED(AddPlayer_PlayerAlreadyRegistered.ENGLISH),

	ADD_PLAYER_ANY_PLAYER_ADDED(AddPlayer_AnyPlayerAdded.ENGLISH),

	ADD_PLAYER_ONE_PLAYER_ADDED(AddPlayer_OnePlayerAdded.ENGLISH),

	ADD_PLAYER_SEVERAL_PLAYERS_ADDED(AddPlayer_SeveralPlayersAdded.ENGLISH);

	private IMessage source;

	private EnglishTeamAddMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (EnglishTeamAddMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
