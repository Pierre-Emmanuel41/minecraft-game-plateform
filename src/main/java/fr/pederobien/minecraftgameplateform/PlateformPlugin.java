package fr.pederobien.minecraftgameplateform;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.game.PauseCommand;
import fr.pederobien.minecraftgameplateform.commands.game.StartCommand;
import fr.pederobien.minecraftgameplateform.commands.game.StopCommand;

public class PlateformPlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		new StartCommand(this);
		new PauseCommand(this);
		new StopCommand(this);
	}
}
