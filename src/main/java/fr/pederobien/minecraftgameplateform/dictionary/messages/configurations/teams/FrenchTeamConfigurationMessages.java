package fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams;

import fr.pederobien.minecraftdictionary.interfaces.IDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;

public enum FrenchTeamConfigurationMessages {
	TEAM_EXPLANATION(Team_Explanation.FRENCH),

	TEAM_ADD_EXPLANATION(Add_Explanation.FRENCH),

	TEAM_REMOVE_EXPLANATION(Remove_Explanation.FRENCH),

	TEAM_MODIFY_EXPLANATION(Modify_Explanation.FRENCH),

	TEAM_LIST_EXPLANATION(List_Explanation.FRENCH),

	TEAM_LIST_ANY_EXISTING_TEAM(List_AnyExistingTeam.FRENCH),

	TEAM_LIST_ONE_EXISTING_TEAM(List_OneExistingTeam.FRENCH),

	TEAM_LIST_SEVERAL_EXISTING_TEAMS(List_SeveralExistingTeams.FRENCH),

	TEAM_MOVE_EXPLANATION(Move_Explanation.FRENCH),

	TEAM_MOVE_PLAYER_NAME_IS_MISSING(Move_PlayerNameIsMissing.FRENCH),

	TEAM_MOVE_TEAM_NAME_IS_MISSING(Move_TeamNameIsMissing.FRENCH),

	TEAM_MOVE_PLAYER_DOES_NOT_EXIST(Move_PlayerDoesNotExist.FRENCH),

	TEAM_MOVE_PLAYER_NOT_REGISTERED(Move_PlayerNotRegistered.FRENCH),

	TEAM_MOVE_TEAM_DOES_NOT_EXIST(Move_TeamDoesNotExist.FRENCH),

	TEAM_MOVE_TEAMS_ARE_THE_SAME(Move_TeamsAreTheSame.FRENCH),

	TEAM_MOVE_PLAYER_MOVED(Move_PlayerMoved.FRENCH);

	private IMessage source;

	private FrenchTeamConfigurationMessages(IMessage source) {
		this.source = source;
	}

	/**
	 * Register all fields in this enumeration to the given dictionary.
	 * 
	 * @param dictionary
	 */
	public static void setDictionary(IDictionary dictionary) {
		for (FrenchTeamConfigurationMessages message : values())
			dictionary.register(message.getSource());
	}

	/**
	 * @return The message associated to this field.
	 */
	public IMessage getSource() {
		return source;
	}
}
