package fr.pederobien.minecraftgameplateform.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.interfaces.commands.ICommand;

public abstract class AbstractCommand implements ICommand {
	private static final TabCompleter DEFAULT_COMPLETER;
	private JavaPlugin plugin;
	private String label;

	static {
		DEFAULT_COMPLETER = new TabCompleter() {
			@Override
			public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
				return new ArrayList<String>();
			}
		};
	}

	protected AbstractCommand(JavaPlugin plugin, String label) {
		this.plugin = plugin;
		this.label = label;
	}

	@Override
	public JavaPlugin getPlugin() {
		return plugin;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public boolean isAvailable() {
		return true;
	}

	@Override
	public void setAvailable(boolean isAvailable) {

	}

	@Override
	public TabCompleter getTabCompleter() {
		return DEFAULT_COMPLETER;
	}
}
