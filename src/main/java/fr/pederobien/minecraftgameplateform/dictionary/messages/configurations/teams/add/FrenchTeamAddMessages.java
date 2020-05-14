package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public enum FrenchTeamAddMessages {
	ADD_TEAM_EXPLANATION(AddTeam_Explanation.FRENCH),

	ADD_TEAM_TEAM_NAME_IS_MISSING(AddTeam_TeamNameIsMissing.FRENCH),

	ADD_TEAM_COLOR_NAME_IS_MISSING(AddTeam_ColorNameIsMissing.FRENCH),

	ADD_TEAM_COLOR_DOES_NOT_EXIST(AddTeam_ColorDoesNotExist.FRENCH),

	ADD_TEAM_TEAM_NAME_FORBIDDEEN(AddTeam_TeamNameForbidden.FRENCH),

	ADD_TEAM_TEAM_NAME_ALREADY_USED(AddTeam_TeamNameAlreadyUsed.FRENCH),

	ADD_TEAM_COLOR_ALREADY_USED(AddTeam_ColorAlreadyUsed.FRENCH),

	ADD_TEAM_TEAM_ADDED(AddTeam_TeamAdded.FRENCH),

	ADD_PLAYER_EXPLANATION(AddPlayer_Explanation.FRENCH),

	ADD_PLAYER_TEAM_NAME_IS_MISSING(AddPlayer_TeamNameIsMissing.FRENCH),

	ADD_PLAYER_TEAM_DOES_NOT_EXIST(AddPlayer_TeamDoesNotExist.FRENCH),

	ADD_PLAYER_PLAYER_ALREADY_REGISTERED(AddPlayer_PlayerAlreadyRegistered.FRENCH),

	ADD_PLAYER_ANY_PLAYER_ADDED(AddPlayer_AnyPlayerAdded.FRENCH),

	ADD_PLAYER_ONE_PLAYER_ADDED(AddPlayer_OnePlayerAdded.FRENCH),

	ADD_PLAYER_SEVERAL_PLAYERS_ADDED(AddPlayer_SeveralPlayersAdded.FRENCH);

	private IMinecraftMessage source;

	private FrenchTeamAddMessages(IMinecraftMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (FrenchTeamAddMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMinecraftMessage getSource() {
		return source;
	}
}
