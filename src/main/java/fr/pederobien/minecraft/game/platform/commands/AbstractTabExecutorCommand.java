package fr.pederobien.minecraft.game.platform.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AbstractTabExecutorCommand<T extends CommandExecutor & TabCompleter> extends AbstractCommand {
	private T parent;

	protected AbstractTabExecutorCommand(JavaPlugin plugin, String label, T parent) {
		super(plugin, label);
		this.parent = parent;
		getCommandHelper().register(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return parent.onCommand(sender, command, label, args);
	}

	@Override
	public TabCompleter getTabCompleter() {
		return parent;
	}

	/**
	 * @return The parent, ie the root of this command.
	 */
	protected T getParent() {
		return parent;
	}
}
