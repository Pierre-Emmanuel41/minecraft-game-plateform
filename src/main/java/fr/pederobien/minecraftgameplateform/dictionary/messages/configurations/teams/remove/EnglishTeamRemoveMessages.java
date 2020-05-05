package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum EnglishTeamRemoveMessages {
	REMOVE_TEAM_EXPLANATION(RemoveTeam_Explanation.ENGLISH),

	REMOVE_TEAM_ALL_TEAMS_REMOVED(RemoveTeam_AllTeamsRemoved.ENGLISH),

	REMOVE_TEAM_TEAM_DOES_NOT_EXIST(RemoveTeam_TeamDoesNotExist.ENGLISH),

	REMOVE_TEAM_ANY_TEAM_REMOVED(RemoveTeam_AnyTeamRemoved.ENGLISH),

	REMOVE_TEAM_ONE_TEAM_REMOVED(RemoveTeam_OneTeamRemoved.ENGLISH),

	REMOVE_TEAM_SEVERAL_TEAMS_REMOVED(RemoveTeam_SeveralTeamsRemoved.ENGLISH),

	REMOVE_PLAYER_EXPLANATION(RemovePlayer_Explanation.ENGLISH),

	REMOVE_PLAYER_ALL_PLAYERS_REMOVED(RemovePlayer_AllPlayersRemoved.ENGLISH),

	REMOVE_PLAYER_PLAYER_NOT_REGISTER(RemovePlayer_PlayerNotRegistered.ENGLISH),

	REMOVE_PLAYER_ANY_PLAYER_REMOVED(RemovePlayer_AnyPlayerRemoved.ENGLISH),

	REMOVE_PLAYER_ONE_PLAYER_REMOVED(RemovePlayer_OnePlayerRemoved.ENGLISH),

	REMOVE_PLAYER_SEVERAL_PLAYERS_REMOVED(RemovePlayer_SeveralPlayersRemoved.ENGLISH);

	private IMessage source;

	private EnglishTeamRemoveMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (EnglishTeamRemoveMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
