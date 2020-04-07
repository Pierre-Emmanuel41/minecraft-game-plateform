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

public class FrenchDictionary extends AbstractDictionary {

	public FrenchDictionary() {
		super(Locale.FRANCE, Locale.FRENCH, Locale.CANADA_FRENCH);

		// Code for the explanation of the helper
		register(HelpExplanation.FRENCH);

		// Code for common command messages
		register(Common_BadIntegerFormat.FRENCH);
		register(Common_MissingCoordinates.FRENCH);
		register(CommonNew_TabComplete.FRENCH);
		register(CommonNew_NameMustNotStartWithDefault.FRENCH);
		register(CommonRename_TabComplete.FRENCH);

		// Code for common world structure command messages
		register(CommonCenter_Explanation.FRENCH);
		register(CommonCenter_CenterDefined.FRENCH);
		register(CommonDimension_BadDimensionFormat.FRENCH);
		register(CommonDimension_MissingDimension.FRENCH);

		// Code for spawn command messages
		register(SpawnParentExplanation.FRENCH);
		register(NewSpawn_Explanation.FRENCH);
		register(NewSpawn_NameIsMissing.FRENCH);
		register(NewSpawn_NameAlreadyTaken.FRENCH);
		register(NewSpawn_SpawnCreated.FRENCH);
		register(DimensionSpawn_Explanation.FRENCH);
		register(DimensionSpawn_Defined.FRENCH);
		register(RenameSpawn_Explanation.FRENCH);
		register(RenameSpawn_NameAlreadyTaken.FRENCH);

		// Code for game messages
		register(StartingGame.FRENCH);
		register(PausingGame.FRENCH);
		register(ResumingGame.FRENCH);
		register(StoppingGame.FRENCH);
		register(NoConfigurationSetted.FRENCH);
	}
}
