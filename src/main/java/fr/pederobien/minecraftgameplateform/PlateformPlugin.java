package fr.pederobien.minecraftgameplateform;

import java.io.FileNotFoundException;
import java.nio.file.Path;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.dictionary.interfaces.IDictionaryParser;
import fr.pederobien.minecraftgameplateform.border.BorderCommand;
import fr.pederobien.minecraftgameplateform.commands.game.PauseCommand;
import fr.pederobien.minecraftgameplateform.commands.game.StartCommand;
import fr.pederobien.minecraftgameplateform.commands.game.StopCommand;
import fr.pederobien.minecraftgameplateform.gamerules.GameRule;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameRule;
import fr.pederobien.minecraftgameplateform.pltf.PlateformCommand;
import fr.pederobien.minecraftgameplateform.pltf.PlateformConfiguration;
import fr.pederobien.minecraftgameplateform.spawn.SpawnCommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class PlateformPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		Plateform.setPlateformConfiguration(new PlateformConfiguration(this));

		new StartCommand(this);
		new PauseCommand(this);
		new StopCommand(this);

		new SpawnCommand(this);
		new BorderCommand(this);

		new PlateformCommand(this);

		registerDictionaries();

		for (IGameRule<?> rule : GameRule.RULES)
			Plateform.getGameRuleHelper().register(rule);
	}

	@Override
	public void onDisable() {
		Plateform.getPersistenceCenter().save();
	}

	private void registerDictionaries() {
		String[] dictionaries = new String[] { "Common.xml", "Game.xml", "WorldStructure.xml", "Configurations.xml", "Spawn.xml", "Border.xml", "Borders.xml",
				"Entry.xml", "GameRule.xml" };
		// Registering French dictionaries
		registerDictionary("French", dictionaries);

		// Registering English dictionaries
		registerDictionary("English", dictionaries);
	}

	private void registerDictionary(String parent, String... dictionaryNames) {
		Path jarPath = Plateform.ROOT.getParent().resolve(Plateform.getJarName("minecraft-game-plateform"));
		String dictionariesFolder = "resources/dictionaries/".concat(parent).concat("/");
		for (String name : dictionaryNames)
			registerDictionary(Plateform.getDefaultDictionaryParser(dictionariesFolder.concat(name)), jarPath);
	}

	private void registerDictionary(IDictionaryParser parser, Path jarPath) {
		try {
			Plateform.getNotificationCenter().getDictionaryContext().register(parser, jarPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
