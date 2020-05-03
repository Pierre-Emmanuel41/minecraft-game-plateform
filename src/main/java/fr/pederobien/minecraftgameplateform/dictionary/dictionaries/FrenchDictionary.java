package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftdictionary.impl.AbstractDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.HelpExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.EGameConfigurationMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Add_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.List_AnyExistingTeam;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.List_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.List_OneExistingTeam;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.List_SeveralExistingTeams;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Modify_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_PlayerDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_PlayerMoved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_PlayerNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_PlayerNotRegistered;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_TeamDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_TeamNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_TeamsAreTheSame;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Remove_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Team_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.ETeamAddMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ETeamModifyMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemovePlayer_AllPlayersRemoved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemovePlayer_AnyPlayerRemoved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemovePlayer_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemovePlayer_OnePlayerRemoved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemovePlayer_PlayerNotRegistered;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemovePlayer_SeveralPlayersRemoved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemoveTeam_AllTeamsRemoved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemoveTeam_AnyTeamRemoved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemoveTeam_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemoveTeam_OneTeamRemoved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemoveTeam_SeveralTeamsRemoved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.RemoveTeam_TeamDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.EGameMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.EWorldStructureMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessages;

public class FrenchDictionary extends AbstractDictionary {

	public FrenchDictionary() {
		super(Locale.FRANCE, Locale.FRENCH, Locale.CANADA_FRENCH);

		// Code for the explanation of the helper
		register(HelpExplanation.FRENCH);

		// Code for common command messages
		for (IMessage message : ECommonMessages.FRENCH.getMessages())
			register(message);

		// Code for game messages
		for (IMessage message : EGameMessages.FRENCH.getMessages())
			register(message);

		// Code for common world structure command messages
		for (IMessage message : EWorldStructureMessages.FRENCH.getMessages())
			register(message);

		// Code for spawn command messages
		for (IMessage message : ESpawnMessages.FRENCH.getMessages())
			register(message);

		// Code for game configuration command messages
		for (IMessage message : EGameConfigurationMessages.FRENCH.getMessages())
			register(message);

		// Code for game teams configuration command messages
		register(Team_Explanation.FRENCH);
		register(Add_Explanation.FRENCH);

		// Code for team add command messages
		for (IMessage message : ETeamAddMessages.FRENCH.getMessages())
			register(message);

		register(Remove_Explanation.FRENCH);
		register(RemoveTeam_Explanation.FRENCH);
		register(RemoveTeam_AllTeamsRemoved.FRENCH);
		register(RemoveTeam_TeamDoesNotExist.FRENCH);
		register(RemoveTeam_AnyTeamRemoved.FRENCH);
		register(RemoveTeam_OneTeamRemoved.FRENCH);
		register(RemoveTeam_SeveralTeamsRemoved.FRENCH);
		register(RemovePlayer_Explanation.FRENCH);
		register(RemovePlayer_AllPlayersRemoved.FRENCH);
		register(RemovePlayer_PlayerNotRegistered.FRENCH);
		register(RemovePlayer_AnyPlayerRemoved.FRENCH);
		register(RemovePlayer_OnePlayerRemoved.FRENCH);
		register(RemovePlayer_SeveralPlayersRemoved.FRENCH);
		register(Modify_Explanation.FRENCH);

		// Code for team add command messages
		for (IMessage message : ETeamModifyMessages.FRENCH.getMessages())
			register(message);

		register(List_Explanation.FRENCH);
		register(List_AnyExistingTeam.FRENCH);
		register(List_OneExistingTeam.FRENCH);
		register(List_SeveralExistingTeams.FRENCH);
		register(Move_Explanation.FRENCH);
		register(Move_PlayerNameIsMissing.FRENCH);
		register(Move_TeamNameIsMissing.FRENCH);
		register(Move_PlayerDoesNotExist.FRENCH);
		register(Move_PlayerNotRegistered.FRENCH);
		register(Move_TeamDoesNotExist.FRENCH);
		register(Move_TeamsAreTheSame.FRENCH);
		register(Move_PlayerMoved.FRENCH);
	}
}
