package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftgameplateform.dictionary.AbstractDictionary;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.BadCoordinatesFormat;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.HelpExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.CommonCenterExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.CommonCenter_CenterDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.spawn.SpawnParentExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.NoConfigurationSetted;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.StartingGame;

public class EnglishDictionary extends AbstractDictionary {

	public EnglishDictionary() {
		super(Locale.UK, Locale.US, Locale.ENGLISH, Locale.CANADA);

		// Code for command messages
		register(HelpExplanation.ENGLISH);
		register(BadCoordinatesFormat.ENGLISH);

		// Code for common world structure command messages
		register(CommonCenterExplanation.ENGLISH);
		register(CommonCenter_CenterDefined.ENGLISH);

		// Code for spawn command messages
		register(SpawnParentExplanation.ENGLISH);

		// Code for game messages
		register(StartingGame.ENGLISH);
		register(NoConfigurationSetted.ENGLISH);
	}
}
