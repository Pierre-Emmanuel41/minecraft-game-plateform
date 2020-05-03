package fr.pederobien.minecraftgameplateform.dictionary.dictionaries;

import java.util.Locale;

import fr.pederobien.minecraftdictionary.impl.AbstractDictionary;
import fr.pederobien.minecraftdictionary.interfaces.IMessage;
import fr.pederobien.minecraftgameplateform.dictionary.messages.HelpExplanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.common.ECommonMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.EGameConfigurationMessages;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Add_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.List_AnyExistingTeam;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.List_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.List_OneExistingTeam;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.List_SeveralExistingTeams;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Modify_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_PlayerDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_PlayerMoved;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_PlayerNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_PlayerNotRegistered;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_TeamDoesNotExist;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_TeamNameIsMissing;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Move_TeamsAreTheSame;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Remove_Explanation;
import fr.pederobien.minecraftgameplateform.dictionary.messages.configurations.teams.Team_Explanation;
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
		register(Team_Explanation.ENGLISH);
		register(Add_Explanation.ENGLISH);

		// Code for team add command messages
		for (IMessage message : ETeamAddMessages.ENGLISH.getMessages())
			register(message);

		register(Remove_Explanation.ENGLISH);
		// Code for team remove command messages
		for (IMessage message : ETeamRemoveMessages.ENGLISH.getMessages())
			register(message);

		register(Modify_Explanation.ENGLISH);
		// Code for team modify command messages
		for (IMessage message : ETeamModifyMessages.ENGLISH.getMessages())
			register(message);

		register(List_Explanation.ENGLISH);
		register(List_AnyExistingTeam.ENGLISH);
		register(List_OneExistingTeam.ENGLISH);
		register(List_SeveralExistingTeams.ENGLISH);
		register(Move_Explanation.ENGLISH);
		register(Move_PlayerNameIsMissing.ENGLISH);
		register(Move_TeamNameIsMissing.ENGLISH);
		register(Move_PlayerDoesNotExist.ENGLISH);
		register(Move_PlayerNotRegistered.ENGLISH);
		register(Move_TeamDoesNotExist.ENGLISH);
		register(Move_TeamsAreTheSame.ENGLISH);
		register(Move_PlayerMoved.ENGLISH);
	}
}
