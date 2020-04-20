package fr.pederobien.minecraftgameplateform;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.game.PauseCommand;
import fr.pederobien.minecraftgameplateform.commands.game.StartCommand;
import fr.pederobien.minecraftgameplateform.commands.game.StopCommand;
import fr.pederobien.minecraftgameplateform.dictionary.dictionaries.EnglishDictionary;
import fr.pederobien.minecraftgameplateform.dictionary.dictionaries.FrenchDictionary;
import fr.pederobien.minecraftgameplateform.spawn.commands.SpawnCommand;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class PlateformPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		new StartCommand(this);
		new PauseCommand(this);
		new StopCommand(this);

		new SpawnCommand(this);

		Plateform.getNotificationCenter().getDictionaryContext().register(this, new EnglishDictionary());
		Plateform.getNotificationCenter().getDictionaryContext().register(this, new FrenchDictionary());
	}

	@Override
	public void onDisable() {
		Plateform.getPersistenceCenter().save();
	}
}
