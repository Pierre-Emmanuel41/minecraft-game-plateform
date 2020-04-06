package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftgameplateform.dictionary.AbstractDictionary;
import fr.pederobien.minecraftgameplateform.dictionary.messages.HelpExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.NoConfigurationSetted;
import fr.pederobien.minecraftgameplateform.dictionary.messages.StartingGame;

public class EnglishDictionary extends AbstractDictionary {

	public EnglishDictionary() {
		super(Locale.UK, Locale.US, Locale.ENGLISH, Locale.CANADA);

		// Code for command messages
		register(HelpExplanation.ENGLISH);

		// Code for game messages
		register(StartingGame.ENGLISH);
		register(NoConfigurationSetted.ENGLISH);
	}
}
