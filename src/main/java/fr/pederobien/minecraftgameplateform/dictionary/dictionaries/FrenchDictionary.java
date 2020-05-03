package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftgameplateform.dictionary.messages.HelpExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.EGameConfigurationMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.ETeamConfigurationMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.ETeamAddMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ETeamModifyMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.ETeamRemoveMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.EGameMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.EWorldStructureMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessages;
import fr.pederobien.minecraftgameplateform.impl.AbstractPlateformDictionary;

public class FrenchDictionary extends AbstractPlateformDictionary {

	public FrenchDictionary() {
		super(Locale.FRANCE, Locale.FRENCH, Locale.CANADA_FRENCH);

		// Code for the explanation of the helper
		register(HelpExplanation.FRENCH);

		register(ECommonMessages.FRENCH, EGameMessages.FRENCH, EWorldStructureMessages.FRENCH, ESpawnMessages.FRENCH, EGameConfigurationMessages.FRENCH);
		register(ETeamConfigurationMessages.FRENCH, ETeamAddMessages.FRENCH, ETeamRemoveMessages.FRENCH, ETeamModifyMessages.FRENCH);

	}
}
