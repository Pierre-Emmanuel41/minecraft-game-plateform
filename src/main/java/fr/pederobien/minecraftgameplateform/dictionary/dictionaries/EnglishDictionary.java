package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftgameplateform.dictionary.messages.common.EnglishCommonMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.EnglishGameConfigurationMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.EnglishTeamConfigurationMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.EnglishTeamAddMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.EnglishTeamModifyMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.EnglishTeamRemoveMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.EnglishGameMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.EnglishWorldStructureMessages;
import fr.pederobien.minecraftgameplateform.impl.element.AbstractPlateformDictionary;
import fr.pederobien.minecraftgameplateform.spawn.messages.EnglishSpawnMessages;

public class EnglishDictionary extends AbstractPlateformDictionary {

	public EnglishDictionary() {
		super(Locale.UK, Locale.US, Locale.ENGLISH, Locale.CANADA);

		EnglishCommonMessages.setDictionary(this);
		EnglishGameMessages.setDictionary(this);
		EnglishWorldStructureMessages.setDictionary(this);
		EnglishGameConfigurationMessages.setDictionary(this);
		EnglishTeamConfigurationMessages.setDictionary(this);
		EnglishTeamAddMessages.setDictionary(this);
		EnglishTeamRemoveMessages.setDictionary(this);
		EnglishTeamModifyMessages.setDictionary(this);
		EnglishSpawnMessages.setDictionary(this);
		EnglishSpawnMessages.setDictionary(this);
	}
}
