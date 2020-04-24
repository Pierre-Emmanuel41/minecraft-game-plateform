package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftdictionary.impl.AbstractDictionary;
import fr.pederobien.minecraftgameplateform.dictionary.messages.HelpExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.CommonNew_TabComplete;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.CommonRename_TabComplete;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.Common_ArgumentNotFound;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.Common_BadIntegerFormat;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.Common_NameMustNotStartWithDefault;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.Common_NotAvailableArgument;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.Common_NotAvailableCommand;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.AsCurrent_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.AsCurrent_GameStyleDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.CommonLoad_StyleDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_NegativeTicsNumber;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_OnTabComplete;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_OneTicDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_SeveralTicsDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.ScoreboardRefresh_TicsNumberIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.AddPlayer_PlayerDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Add_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddPlayer_AnyPlayerAdded;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddPlayer_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddPlayer_OnePlayerAdded;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddPlayer_SeveralPlayersAdded;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_ColorAlreadyUsed;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_ColorDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_ColorNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_TeamAdded;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_TeamNameAlreadyUsed;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_TeamNameForbidden;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.AddTeam_TeamNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.NoConfigurationSetted;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.PausingGame;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.ResumingGame;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.StartingGame;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.StoppingGame;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.CommonDimension_BadDimensionFormat;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.CommonDimension_MissingDimension;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.CommonWorld_WorldDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.Common_MissingCoordinates;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.CenterSpawn_CenterDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.CenterSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.CurrentSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.CurrentSpawn_OnCurrent;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.DeleteSpawn_DidNotDelete;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.DeleteSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.DeleteSpawn_NameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.DeleteSpawn_SpawnDeleted;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.DimensionSpawn_Defined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.DimensionSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ExtractSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ExtractSpawn_SpawnExtracted;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.LaunchSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.LaunchSpawn_NoCurrentSpawn;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.LaunchSpawn_SpawnDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.LaunchSpawn_SpawnLaunched;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.LaunchSpawn_WorldIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ListSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ListSpawn_NoElement;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ListSpawn_OneElement;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ListSpawn_SeveralElements;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_NameAlreadyTaken;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_NameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_SpawnCreated;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.PlayerSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.PlayerSpawn_PlayerSpawnDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.RandomSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.RandomSpawn_WorldOrCoordinatesAreMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.RemoveSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.RemoveSpawn_SpawnRemoved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.RenameSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.RenameSpawn_NameAlreadyTaken;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.RenameSpawn_NameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.RenameSpawn_SpawnRenamed;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.SaveSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.SaveSpawn_SpawnSaved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.SpawnParentExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.WorldSpawn_WorldDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.WorldSpawn_WorldNameIsMissing;

public class FrenchDictionary extends AbstractDictionary {

	public FrenchDictionary() {
		super(Locale.FRANCE, Locale.FRENCH, Locale.CANADA_FRENCH);

		// Code for the explanation of the helper
		register(HelpExplanation.FRENCH);

		// Code for common command messages
		register(Common_BadIntegerFormat.FRENCH);
		register(Common_MissingCoordinates.FRENCH);
		register(Common_ArgumentNotFound.FRENCH);
		register(Common_NotAvailableArgument.FRENCH);
		register(Common_NotAvailableCommand.FRENCH);
		register(Common_NameMustNotStartWithDefault.FRENCH);
		register(CommonNew_TabComplete.FRENCH);
		register(CommonRename_TabComplete.FRENCH);

		// Code for common world structure command messages
		register(CommonDimension_BadDimensionFormat.FRENCH);
		register(CommonDimension_MissingDimension.FRENCH);

		// Code for spawn command messages
		register(SpawnParentExplanation.FRENCH);
		register(NewSpawn_Explanation.FRENCH);
		register(NewSpawn_NameIsMissing.FRENCH);
		register(NewSpawn_NameAlreadyTaken.FRENCH);
		register(NewSpawn_SpawnCreated.FRENCH);
		register(NewSpawn_Explanation.FRENCH);
		register(WorldSpawn_WorldNameIsMissing.FRENCH);
		register(CommonWorld_WorldDoesNotExist.FRENCH);
		register(WorldSpawn_WorldDefined.FRENCH);
		register(CenterSpawn_Explanation.FRENCH);
		register(CenterSpawn_CenterDefined.FRENCH);
		register(DimensionSpawn_Explanation.FRENCH);
		register(DimensionSpawn_Defined.FRENCH);
		register(RenameSpawn_Explanation.FRENCH);
		register(RenameSpawn_NameAlreadyTaken.FRENCH);
		register(RenameSpawn_NameIsMissing.FRENCH);
		register(RenameSpawn_SpawnRenamed.FRENCH);
		register(SaveSpawn_Explanation.FRENCH);
		register(SaveSpawn_SpawnSaved.FRENCH);
		register(ListSpawn_Explanation.FRENCH);
		register(ListSpawn_NoElement.FRENCH);
		register(ListSpawn_OneElement.FRENCH);
		register(ListSpawn_SeveralElements.FRENCH);
		register(DeleteSpawn_Explanation.FRENCH);
		register(DeleteSpawn_NameIsMissing.FRENCH);
		register(DeleteSpawn_SpawnDeleted.FRENCH);
		register(DeleteSpawn_DidNotDelete.FRENCH);
		register(ExtractSpawn_Explanation.FRENCH);
		register(ExtractSpawn_SpawnExtracted.FRENCH);
		register(RemoveSpawn_Explanation.FRENCH);
		register(RemoveSpawn_SpawnRemoved.FRENCH);
		register(LaunchSpawn_Explanation.FRENCH);
		register(LaunchSpawn_NoCurrentSpawn.FRENCH);
		register(LaunchSpawn_WorldIsMissing.FRENCH);
		register(LaunchSpawn_SpawnDoesNotExist.FRENCH);
		register(LaunchSpawn_SpawnLaunched.FRENCH);
		register(CurrentSpawn_Explanation.FRENCH);
		register(CurrentSpawn_OnCurrent.FRENCH);
		register(PlayerSpawn_Explanation.FRENCH);
		register(PlayerSpawn_PlayerSpawnDefined.FRENCH);
		register(RandomSpawn_Explanation.FRENCH);
		register(RandomSpawn_WorldOrCoordinatesAreMissing.FRENCH);

		// Code for game messages
		register(StartingGame.FRENCH);
		register(PausingGame.FRENCH);
		register(ResumingGame.FRENCH);
		register(StoppingGame.FRENCH);
		register(NoConfigurationSetted.FRENCH);

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
		register(AddPlayer_PlayerDoesNotExist.FRENCH);
		register(AddPlayer_AnyPlayerAdded.FRENCH);
		register(AddPlayer_OnePlayerAdded.FRENCH);
		register(AddPlayer_SeveralPlayersAdded.FRENCH);
	}
}
