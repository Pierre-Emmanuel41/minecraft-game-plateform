package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftgameplateform.dictionary.AbstractDictionary;
import fr.pederobien.minecraftgameplateform.dictionary.messages.HelpExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.BadCoordinatesFormat;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.CommonNew_NameMustNotStartWithDefault;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.CommonNew_TabComplete;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.MissingCoordinates;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.NoConfigurationSetted;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.StartingGame;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.CommonCenter_CenterDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.CommonCenter_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.CommonDimension_BadDimensionFormat;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.CommonDimension_MissingDimension;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.DimensionSpawn_Defined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.DimensionSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_NameAlreadyTaken;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_NameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.NewSpawn_SpawnCreated;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.SpawnParentExplanation;

public class EnglishDictionary extends AbstractDictionary {

	public EnglishDictionary() {
		super(Locale.UK, Locale.US, Locale.ENGLISH, Locale.CANADA);

		// Code for command messages
		register(HelpExplanation.ENGLISH);
		register(BadCoordinatesFormat.ENGLISH);
		register(MissingCoordinates.ENGLISH);
		register(CommonNew_TabComplete.ENGLISH);
		register(CommonNew_NameMustNotStartWithDefault.ENGLISH);

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

		// Code for game messages
		register(StartingGame.ENGLISH);
		register(NoConfigurationSetted.ENGLISH);
	}
}
