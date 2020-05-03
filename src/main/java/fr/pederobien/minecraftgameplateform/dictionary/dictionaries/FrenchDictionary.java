package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftdictionary.impl.AbstractDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.HelpExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.AsCurrent_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.AsCurrent_GameStyleDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.CommonLoad_StyleDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_NegativeTicsNumber;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_OnTabComplete;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_OneTicDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_SeveralTicsDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_TicsNumberIsMissing;
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
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddPlayer_AnyPlayerAdded;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddPlayer_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddPlayer_OnePlayerAdded;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddPlayer_PlayerAlreadyRegistered;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddPlayer_SeveralPlayersAdded;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddPlayer_TeamDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddPlayer_TeamNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_ColorAlreadyUsed;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_ColorDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_ColorNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_TeamAdded;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_TeamNameAlreadyUsed;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_TeamNameForbidden;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_TeamNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyColor_ColorAlreadyUsed;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyColor_ColorDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyColor_ColorNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyColor_ColorUpdated;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyColor_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyColor_TeamDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyColor_TeamNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyName_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyName_NameIsForbidden;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyName_NewNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyName_OldNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyName_TeamDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyName_TeamNameAlreadyUsed;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ModifyName_TeamRenamed;
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
		register(AsCurrent_Explanation.FRENCH);
		register(AsCurrent_GameStyleDefined.FRENCH);
		register(CommonLoad_StyleDoesNotExist.FRENCH);
		register(ScoreboardRefresh_Explanation.FRENCH);
		register(ScoreboardRefresh_OnTabComplete.FRENCH);
		register(ScoreboardRefresh_NegativeTicsNumber.FRENCH);
		register(ScoreboardRefresh_TicsNumberIsMissing.FRENCH);
		register(ScoreboardRefresh_OneTicDefined.FRENCH);
		register(ScoreboardRefresh_SeveralTicsDefined.FRENCH);

		// Code for game teams configuration command messages
		register(Team_Explanation.FRENCH);
		register(Add_Explanation.FRENCH);
		register(AddTeam_Explanation.FRENCH);
		register(AddTeam_TeamNameIsMissing.FRENCH);
		register(AddTeam_ColorNameIsMissing.FRENCH);
		register(AddTeam_ColorDoesNotExist.FRENCH);
		register(AddTeam_TeamNameForbidden.FRENCH);
		register(AddTeam_TeamNameAlreadyUsed.FRENCH);
		register(AddTeam_ColorAlreadyUsed.FRENCH);
		register(AddTeam_TeamAdded.FRENCH);
		register(AddPlayer_Explanation.FRENCH);
		register(AddPlayer_TeamNameIsMissing.FRENCH);
		register(AddPlayer_TeamDoesNotExist.FRENCH);
		register(AddPlayer_PlayerAlreadyRegistered.FRENCH);
		register(AddPlayer_AnyPlayerAdded.FRENCH);
		register(AddPlayer_OnePlayerAdded.FRENCH);
		register(AddPlayer_SeveralPlayersAdded.FRENCH);
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
		register(ModifyName_Explanation.FRENCH);
		register(ModifyName_OldNameIsMissing.FRENCH);
		register(ModifyName_NewNameIsMissing.FRENCH);
		register(ModifyName_TeamDoesNotExist.FRENCH);
		register(ModifyName_NameIsForbidden.FRENCH);
		register(ModifyName_TeamNameAlreadyUsed.FRENCH);
		register(ModifyName_TeamRenamed.FRENCH);
		register(ModifyColor_Explanation.FRENCH);
		register(ModifyColor_TeamNameIsMissing.FRENCH);
		register(ModifyColor_ColorNameIsMissing.FRENCH);
		register(ModifyColor_TeamDoesNotExist.FRENCH);
		register(ModifyColor_ColorDoesNotExist.FRENCH);
		register(ModifyColor_ColorAlreadyUsed.FRENCH);
		register(ModifyColor_ColorUpdated.FRENCH);
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
