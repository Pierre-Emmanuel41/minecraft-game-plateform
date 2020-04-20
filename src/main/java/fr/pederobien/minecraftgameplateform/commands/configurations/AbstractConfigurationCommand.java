package fr.pederobien.minecraftgameplateform.commands.configurations;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.commands.AbstractCommand;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class AbstractConfigurationCommand<T extends IUnmodifiableNominable> extends AbstractCommand {
	private IParentPersistenceEdition<T> parent;

	protected AbstractConfigurationCommand(JavaPlugin plugin, IParentPersistenceEdition<T> parent) {
		super(plugin, parent.getLabel());
		this.parent = parent;
		getCommandHelper().register(this);
		Plateform.getPersistenceCenter().registerOrUpdate(parent.getPersistence());
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return parent.onCommand(sender, command, label, args);
	}

	@Override
	public TabCompleter getTabCompleter() {
		return parent;
	}
}
