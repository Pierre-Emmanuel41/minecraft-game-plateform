package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.dictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessage;

public enum EnglishTeamConfigurationMessages {
	TEAM_EXPLANATION(Team_Explanation.ENGLISH),

	TEAM_ADD_EXPLANATION(Add_Explanation.ENGLISH),

	TEAM_REMOVE_EXPLANATION(Remove_Explanation.ENGLISH),

	TEAM_MODIFY_EXPLANATION(Modify_Explanation.ENGLISH),

	TEAM_LIST_EXPLANATION(List_Explanation.ENGLISH),

	TEAM_LIST_ANY_EXISTING_TEAM(List_AnyExistingTeam.ENGLISH),

	TEAM_LIST_ONE_EXISTING_TEAM(List_OneExistingTeam.ENGLISH),

	TEAM_LIST_SEVERAL_EXISTING_TEAMS(List_SeveralExistingTeams.ENGLISH),

	TEAM_MOVE_EXPLANATION(Move_Explanation.ENGLISH),

	TEAM_MOVE_PLAYER_NAME_IS_MISSING(Move_PlayerNameIsMissing.ENGLISH),

	TEAM_MOVE_TEAM_NAME_IS_MISSING(Move_TeamNameIsMissing.ENGLISH),

	TEAM_MOVE_PLAYER_DOES_NOT_EXIST(Move_PlayerDoesNotExist.ENGLISH),

	TEAM_MOVE_PLAYER_NOT_REGISTERED(Move_PlayerNotRegistered.ENGLISH),

	TEAM_MOVE_TEAM_DOES_NOT_EXIST(Move_TeamDoesNotExist.ENGLISH),

	TEAM_MOVE_TEAMS_ARE_THE_SAME(Move_TeamsAreTheSame.ENGLISH),

	TEAM_MOVE_PLAYER_MOVED(Move_PlayerMoved.ENGLISH);

	private IMinecraftMessage source;

	private EnglishTeamConfigurationMessages(IMinecraftMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (EnglishTeamConfigurationMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMinecraftMessage getSource() {
		return source;
	}
}
