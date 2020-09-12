package fr.pederobien.minecraftgameplateform.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.interfaces.commands.IParentCommand;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
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
}
