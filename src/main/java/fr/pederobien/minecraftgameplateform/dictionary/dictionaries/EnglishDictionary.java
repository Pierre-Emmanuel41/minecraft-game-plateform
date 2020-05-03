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

public class EnglishDictionary extends AbstractDictionary {

	public EnglishDictionary() {
		super(Locale.UK, Locale.US, Locale.ENGLISH, Locale.CANADA);

		// Code for the explanation of the helper
		register(HelpExplanation.ENGLISH);

		// Code for command messages
		for (IMessage message : ECommonMessages.ENGLISH.getMessages())
			register(message);

		// Code for game messages
		for (IMessage message : EGameMessages.ENGLISH.getMessages())
			register(message);

		// Code for common world structure command messages
		for (IMessage message : EWorldStructureMessages.ENGLISH.getMessages())
			register(message);

		// Code for spawn command messages
		for (IMessage message : ESpawnMessages.ENGLISH.getMessages())
			register(message);

		// Code for game configuration command messages
		register(AsCurrent_Explanation.ENGLISH);
		register(AsCurrent_GameStyleDefined.ENGLISH);
		register(CommonLoad_StyleDoesNotExist.ENGLISH);
		register(ScoreboardRefresh_Explanation.ENGLISH);
		register(ScoreboardRefresh_OnTabComplete.ENGLISH);
		register(ScoreboardRefresh_NegativeTicsNumber.ENGLISH);
		register(ScoreboardRefresh_TicsNumberIsMissing.ENGLISH);
		register(ScoreboardRefresh_OneTicDefined.ENGLISH);
		register(ScoreboardRefresh_SeveralTicsDefined.ENGLISH);

		// Code for game teams configuration command messages
		register(Team_Explanation.ENGLISH);
		register(Add_Explanation.ENGLISH);
		register(AddTeam_Explanation.ENGLISH);
		register(AddTeam_TeamNameIsMissing.ENGLISH);
		register(AddTeam_ColorNameIsMissing.ENGLISH);
		register(AddTeam_ColorDoesNotExist.ENGLISH);
		register(AddTeam_TeamNameForbidden.ENGLISH);
		register(AddTeam_TeamNameAlreadyUsed.ENGLISH);
		register(AddTeam_ColorAlreadyUsed.ENGLISH);
		register(AddTeam_Explanation.ENGLISH);
		register(AddPlayer_Explanation.ENGLISH);
		register(AddPlayer_TeamNameIsMissing.ENGLISH);
		register(AddPlayer_TeamDoesNotExist.ENGLISH);
		register(AddPlayer_PlayerAlreadyRegistered.ENGLISH);
		register(AddPlayer_AnyPlayerAdded.ENGLISH);
		register(AddPlayer_OnePlayerAdded.ENGLISH);
		register(AddPlayer_SeveralPlayersAdded.ENGLISH);
		register(Remove_Explanation.ENGLISH);
		register(RemoveTeam_Explanation.ENGLISH);
		register(RemoveTeam_AllTeamsRemoved.ENGLISH);
		register(RemoveTeam_TeamDoesNotExist.ENGLISH);
		register(RemoveTeam_AnyTeamRemoved.ENGLISH);
		register(RemoveTeam_OneTeamRemoved.ENGLISH);
		register(RemoveTeam_SeveralTeamsRemoved.ENGLISH);
		register(RemovePlayer_Explanation.ENGLISH);
		register(RemovePlayer_AllPlayersRemoved.ENGLISH);
		register(RemovePlayer_PlayerNotRegistered.ENGLISH);
		register(RemovePlayer_AnyPlayerRemoved.ENGLISH);
		register(RemovePlayer_OnePlayerRemoved.ENGLISH);
		register(RemovePlayer_SeveralPlayersRemoved.ENGLISH);
		register(Modify_Explanation.ENGLISH);
		register(ModifyName_Explanation.ENGLISH);
		register(ModifyName_OldNameIsMissing.ENGLISH);
		register(ModifyName_NewNameIsMissing.ENGLISH);
		register(ModifyName_TeamDoesNotExist.ENGLISH);
		register(ModifyName_NameIsForbidden.ENGLISH);
		register(ModifyName_TeamNameAlreadyUsed.ENGLISH);
		register(ModifyName_TeamRenamed.ENGLISH);
		register(ModifyColor_Explanation.ENGLISH);
		register(ModifyColor_TeamNameIsMissing.ENGLISH);
		register(ModifyColor_ColorNameIsMissing.ENGLISH);
		register(ModifyColor_TeamDoesNotExist.ENGLISH);
		register(ModifyColor_ColorDoesNotExist.ENGLISH);
		register(ModifyColor_ColorAlreadyUsed.ENGLISH);
		register(ModifyColor_ColorUpdated.ENGLISH);
		register(List_Explanation.ENGLISH);
		register(List_AnyExistingTeam.ENGLISH);
		register(List_OneExistingTeam.ENGLISH);
		register(List_SeveralExistingTeams.ENGLISH);
		register(Move_Explanation.ENGLISH);
		register(Move_PlayerNameIsMissing.ENGLISH);
		register(Move_TeamNameIsMissing.ENGLISH);
		register(Move_PlayerDoesNotExist.ENGLISH);
		register(Move_PlayerNotRegistered.ENGLISH);
		register(Move_TeamDoesNotExist.ENGLISH);
		register(Move_TeamsAreTheSame.ENGLISH);
		register(Move_PlayerMoved.ENGLISH);
	}
}
