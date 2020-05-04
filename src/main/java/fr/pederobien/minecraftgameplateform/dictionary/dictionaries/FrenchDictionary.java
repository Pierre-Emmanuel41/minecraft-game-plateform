package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftgameplateform.border.messages.EBorderMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.FrenchCommonMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.FrenchGameConfigurationMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.ETeamConfigurationMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.add.ETeamAddMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.modify.ETeamModifyMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.remove.ETeamRemoveMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.game.FrenchGameMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.FrenchWorldStructureMessages;
import fr.pederobien.minecraftgameplateform.impl.element.AbstractPlateformDictionary;
import fr.pederobien.minecraftgameplateform.spawn.messages.ESpawnMessages;

public class FrenchDictionary extends AbstractPlateformDictionary {

	public FrenchDictionary() {
		super(Locale.FRANCE, Locale.FRENCH, Locale.CANADA_FRENCH);

		register(ESpawnMessages.FRENCH);
		register(ETeamConfigurationMessages.FRENCH, ETeamAddMessages.FRENCH, ETeamRemoveMessages.FRENCH, ETeamModifyMessages.FRENCH, EBorderMessages.FRENCH);

		FrenchCommonMessages.setDictionary(this);
		FrenchGameMessages.setDictionary(this);
		FrenchWorldStructureMessages.setDictionary(this);
		FrenchGameConfigurationMessages.setDictionary(this);
	}
}
