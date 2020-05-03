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

public class EnglishDictionary extends AbstractDictionary {

	public EnglishDictionary() {
		super(Locale.UK, Locale.US, Locale.ENGLISH, Locale.CANADA);

		// Code for the explanation of the helper
		register(HelpExplanation.ENGLISH);

		// Code for command messages
		for (IMessage message : ECommonMessages.ENGLISH.getMessages())
			register(message);

		// Code for game messages
		for (IMessage message : EGameMessages.ENGLISH.getMessages())
			register(message);

		// Code for common world structure command messages
		for (IMessage message : EWorldStructureMessages.ENGLISH.getMessages())
			register(message);

		// Code for spawn command messages
		for (IMessage message : ESpawnMessages.ENGLISH.getMessages())
			register(message);

		// Code for game configuration command messages
		for (IMessage message : EGameConfigurationMessages.ENGLISH.getMessages())
			register(message);

		// Code for game teams configuration command messages
		for (IMessage message : ETeamConfigurationMessages.ENGLISH.getMessages())
			register(message);

		// Code for team add command messages
		for (IMessage message : ETeamAddMessages.ENGLISH.getMessages())
			register(message);

		// Code for team remove command messages
		for (IMessage message : ETeamRemoveMessages.ENGLISH.getMessages())
			register(message);

		// Code for team modify command messages
		for (IMessage message : ETeamModifyMessages.ENGLISH.getMessages())
			register(message);
	}
}
