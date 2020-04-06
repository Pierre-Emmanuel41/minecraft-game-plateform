package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftgameplateform.dictionary.AbstractDictionary;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.BadCoordinatesFormat;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.MissingCoordinates;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.HelpExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.CommonCenterExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.CommonCenter_CenterDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.CommonDimension_BadDimensionFormat;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.CommonDimension_MissingDimension;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.spawn.DimensionSpawn_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.spawn.SpawnParentExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.NoConfigurationSetted;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.StartingGame;

public class EnglishDictionary extends AbstractDictionary {

	public EnglishDictionary() {
		super(Locale.UK, Locale.US, Locale.ENGLISH, Locale.CANADA);

		// Code for command messages
		register(HelpExplanation.ENGLISH);
		register(BadCoordinatesFormat.ENGLISH);
		register(MissingCoordinates.ENGLISH);

		// Code for common world structure command messages
		register(CommonCenterExplanation.ENGLISH);
		register(CommonCenter_CenterDefined.ENGLISH);
		register(CommonDimension_BadDimensionFormat.ENGLISH);
		register(CommonDimension_MissingDimension.ENGLISH);

		// Code for spawn command messages
		register(SpawnParentExplanation.ENGLISH);
		register(DimensionSpawn_Explanation.ENGLISH);

		// Code for game messages
		register(StartingGame.ENGLISH);
		register(NoConfigurationSetted.ENGLISH);
	}
}
