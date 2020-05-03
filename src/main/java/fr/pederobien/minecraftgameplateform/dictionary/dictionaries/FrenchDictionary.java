package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftdictionary.impl.AbstractDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;
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

public class FrenchDictionary extends AbstractDictionary {

	public FrenchDictionary() {
		super(Locale.FRANCE, Locale.FRENCH, Locale.CANADA_FRENCH);

		// Code for the explanation of the helper
		register(HelpExplanation.FRENCH);

		// Code for common command messages
		for (IMessage message : ECommonMessages.FRENCH.getMessages())
			register(message);

		// Code for game messages
		for (IMessage message : EGameMessages.FRENCH.getMessages())
			register(message);

		// Code for common world structure command messages
		for (IMessage message : EWorldStructureMessages.FRENCH.getMessages())
			register(message);

		// Code for spawn command messages
		for (IMessage message : ESpawnMessages.FRENCH.getMessages())
			register(message);

		// Code for game configuration command messages
		for (IMessage message : EGameConfigurationMessages.FRENCH.getMessages())
			register(message);

		// Code for game teams configuration command messages
		for (IMessage message : ETeamConfigurationMessages.FRENCH.getMessages())
			register(message);

		// Code for team add command messages
		for (IMessage message : ETeamAddMessages.FRENCH.getMessages())
			register(message);

		// Code for team remove command messages
		for (IMessage message : ETeamRemoveMessages.ENGLISH.getMessages())
			register(message);

		// Code for team add command messages
		for (IMessage message : ETeamModifyMessages.FRENCH.getMessages())
			register(message);
	}
}
