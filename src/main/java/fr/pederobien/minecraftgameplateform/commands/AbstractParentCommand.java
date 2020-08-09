package fr.pederobien.minecraftgameplateform.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.interfaces.commands.IParentCommand;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGame;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public abstract class AbstractParentCommand<T extends IUnmodifiableNominable> extends AbstractCommand implements IParentCommand<T> {
	private IParentPersistenceEdition<T> parent;

	protected AbstractParentCommand(JavaPlugin plugin, IParentPersistenceEdition<T> parent, boolean registerPresistence) {
		super(plugin, parent.getLabel());
		this.parent = parent;
		getCommandHelper().register(this);
		if (registerPresistence)
			Plateform.getPersistenceCenter().registerOrUpdate(parent.getPersistence());
	}

	protected AbstractParentCommand(JavaPlugin plugin, IParentPersistenceEdition<T> parent) {
		this(plugin, parent, true);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return parent.onCommand(sender, command, label, args);
	}

	@Override
	public TabCompleter getTabCompleter() {
		return getParent();
	}

	@Override
	public IParentPersistenceEdition<T> getParent() {
		return parent;
	}

	@Override
	public <U extends IGame> boolean onGameIsStarting(U IGame) {
		return true;
	}

	@Override
	public <U extends IGame> void onGameIsStarted(U IGame) {

	}

	@Override
	public <U extends IGame> boolean onGameIsPausing(U IGame) {
		return true;
	}

	@Override
	public <U extends IGame> void onGameIsPaused(U IGame) {

	}

	@Override
	public <U extends IGame> boolean onGameIsResuming(U IGame) {
		return true;
	}

	@Override
	public <U extends IGame> void onGameIsResumed(U IGame) {

	}

	@Override
	public <U extends IGame> boolean onGameIsStopping(U IGame) {
		return true;
	}

	@Override
	public <U extends IGame> void onGameIsStopped(U IGame) {

	}
}
