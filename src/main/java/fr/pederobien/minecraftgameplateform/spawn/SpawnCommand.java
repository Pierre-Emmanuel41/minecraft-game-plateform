package fr.pederobien.minecraftgameplateform.spawn;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.AbstractParentCommand;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGame;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.spawn.commands.SpawnParent;

public class SpawnCommand extends AbstractParentCommand<ISpawn> {

	public SpawnCommand(JavaPlugin plugin) {
		super(plugin, new SpawnParent(plugin));
	}

	@Override
	public <U extends IGame> void onGameIsStarted(U IGame) {
		getParent().get().getListener().setActivated(false);
	}
}
