package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftgameplateform.dictionary.AbstractDictionary;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.HelpExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.CommonCenterExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.CommonCenter_CenterDefined;
import fr.pederobien.minecraftgameplateform.dictionary.messages.explanations.worldstructure.spawn.SpawnParentExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.NoConfigurationSetted;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.StartingGame;

public class FrenchDictionary extends AbstractDictionary {

	public FrenchDictionary() {
		super(Locale.FRANCE, Locale.FRENCH, Locale.CANADA_FRENCH);

		// Code for command messages
		register(HelpExplanation.FRENCH);

		// Code for common world structure command messages
		register(CommonCenterExplanation.FRENCH).register(CommonCenter_CenterDefined.FRENCH);

		// Code for spawn command messages
		register(SpawnParentExplanation.FRENCH);

		// Code for game messages
		register(StartingGame.FRENCH);
		register(NoConfigurationSetted.FRENCH);
	}
}
