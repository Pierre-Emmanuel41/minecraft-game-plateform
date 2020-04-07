package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftgameplateform.dictionary.AbstractDictionary;
import fr.pederobien.minecraftgameplateform.dictionary.messages.HelpExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.CommonNew_NameMustNotStartWithDefault;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.CommonNew_TabComplete;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.CommonRename_TabComplete;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.Common_BadIntegerFormat;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.NoConfigurationSetted;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.PausingGame;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.ResumingGame;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.StartingGame;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.StoppingGame;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.CommonCenter_CenterDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.CommonCenter_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.CommonDimension_BadDimensionFormat;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.CommonDimension_MissingDimension;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.Common_MissingCoordinates;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.DimensionSpawn_Defined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.DimensionSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_NameAlreadyTaken;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_NameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_SpawnCreated;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.RenameSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.RenameSpawn_NameAlreadyTaken;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.SpawnParentExplanation;

public class EnglishDictionary extends AbstractDictionary {

	public EnglishDictionary() {
		super(Locale.UK, Locale.US, Locale.ENGLISH, Locale.CANADA);

		// Code for the explanation of the helper
		register(HelpExplanation.ENGLISH);

		// Code for command messages
		register(Common_BadIntegerFormat.ENGLISH);
		register(Common_MissingCoordinates.ENGLISH);
		register(CommonNew_TabComplete.ENGLISH);
		register(CommonNew_NameMustNotStartWithDefault.ENGLISH);
		register(CommonRename_TabComplete.ENGLISH);

		// Code for common world structure command messages
		register(CommonCenter_Explanation.ENGLISH);
		register(CommonCenter_CenterDefined.ENGLISH);
		register(CommonDimension_BadDimensionFormat.ENGLISH);
		register(CommonDimension_MissingDimension.ENGLISH);

		// Code for spawn command messages
		register(SpawnParentExplanation.ENGLISH);
		register(NewSpawn_Explanation.ENGLISH);
		register(NewSpawn_NameIsMissing.ENGLISH);
		register(NewSpawn_NameAlreadyTaken.ENGLISH);
		register(NewSpawn_SpawnCreated.ENGLISH);
		register(DimensionSpawn_Explanation.ENGLISH);
		register(DimensionSpawn_Defined.ENGLISH);
		register(RenameSpawn_Explanation.ENGLISH);
		register(RenameSpawn_NameAlreadyTaken.ENGLISH);

		// Code for game messages
		register(StartingGame.ENGLISH);
		register(PausingGame.ENGLISH);
		register(ResumingGame.ENGLISH);
		register(StoppingGame.ENGLISH);
		register(NoConfigurationSetted.ENGLISH);
	}
}
