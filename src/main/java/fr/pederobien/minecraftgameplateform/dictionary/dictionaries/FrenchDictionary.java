package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.dictionary.impl.AbstractDictionary;
import fr.pederobien.minecraftgameplateform.border.messages.FrenchBorderMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.FrenchCommonMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.FrenchGameConfigurationMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.FrenchTeamConfigurationMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.FrenchTeamAddMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.FrenchTeamModifyMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.FrenchTeamRemoveMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.FrenchGameMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.FrenchWorldStructureMessages;
import fr.pederobien.minecraftgameplateform.spawn.messages.FrenchSpawnMessages;

public class FrenchDictionary extends AbstractDictionary {

	public FrenchDictionary() {
		super(Locale.FRANCE, Locale.FRENCH, Locale.CANADA_FRENCH);

		FrenchCommonMessages.setDictionary(this);
		FrenchGameMessages.setDictionary(this);
		FrenchWorldStructureMessages.setDictionary(this);
		FrenchGameConfigurationMessages.setDictionary(this);
		FrenchTeamConfigurationMessages.setDictionary(this);
		FrenchTeamAddMessages.setDictionary(this);
		FrenchTeamRemoveMessages.setDictionary(this);
		FrenchTeamModifyMessages.setDictionary(this);
		FrenchSpawnMessages.setDictionary(this);
		FrenchBorderMessages.setDictionary(this);
	}
}
