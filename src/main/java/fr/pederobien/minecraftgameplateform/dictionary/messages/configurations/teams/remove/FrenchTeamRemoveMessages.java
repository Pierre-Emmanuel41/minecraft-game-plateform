package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public enum FrenchTeamRemoveMessages {
	REMOVE_TEAM_EXPLANATION(RemoveTeam_Explanation.FRENCH),

	REMOVE_TEAM_ALL_TEAMS_REMOVED(RemoveTeam_AllTeamsRemoved.FRENCH),

	REMOVE_TEAM_TEAM_DOES_NOT_EXIST(RemoveTeam_TeamDoesNotExist.FRENCH),

	REMOVE_TEAM_ANY_TEAM_REMOVED(RemoveTeam_AnyTeamRemoved.FRENCH),

	REMOVE_TEAM_ONE_TEAM_REMOVED(RemoveTeam_OneTeamRemoved.FRENCH),

	REMOVE_TEAM_SEVERAL_TEAMS_REMOVED(RemoveTeam_SeveralTeamsRemoved.FRENCH),

	REMOVE_PLAYER_EXPLANATION(RemovePlayer_Explanation.FRENCH),

	REMOVE_PLAYER_ALL_PLAYERS_REMOVED(RemovePlayer_AllPlayersRemoved.FRENCH),

	REMOVE_PLAYER_PLAYER_NOT_REGISTER(RemovePlayer_PlayerNotRegistered.FRENCH),

	REMOVE_PLAYER_ANY_PLAYER_REMOVED(RemovePlayer_AnyPlayerRemoved.FRENCH),

	REMOVE_PLAYER_ONE_PLAYER_REMOVED(RemovePlayer_OnePlayerRemoved.FRENCH),

	REMOVE_PLAYER_SEVERAL_PLAYERS_REMOVED(RemovePlayer_SeveralPlayersRemoved.FRENCH);

	private IMinecraftMessage source;

	private FrenchTeamRemoveMessages(IMinecraftMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (FrenchTeamRemoveMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMinecraftMessage getSource() {
		return source;
	}
}
