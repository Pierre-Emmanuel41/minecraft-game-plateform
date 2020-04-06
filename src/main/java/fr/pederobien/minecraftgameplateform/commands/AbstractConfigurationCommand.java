package fr.pederobien.minecraftgameplateform.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public class AbstractConfigurationCommand<T extends IUnmodifiableNominable> extends AbstractCommand {
	private IParentPersistenceEdition<T> parent;

	protected AbstractConfigurationCommand(JavaPlugin plugin, String label, IParentPersistenceEdition<T> parent) {
		super(plugin, label);
		this.parent = parent;
		getCommandHelper().register(this);
		writeDefaultOrUpdate(parent.getPersistence());
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return parent.onCommand(sender, command, label, args);
	}

	@Override
	public TabCompleter getTabCompleter() {
		return parent;
	}

	private void writeDefaultOrUpdate(IPersistence<T> persistence) {
		File file = persistence.getPath().toFile();
		if (!file.exists())
			file.mkdirs();

		file = persistence.getAbsolutePath(persistence.getDefaultContent().getName()).toFile();
		if (!file.exists())
			writeFirstTime(file, persistence);
		else
			update(persistence);
	}

	private void writeFirstTime(File file, IPersistence<T> persistence) {
		BufferedWriter writer = null;
		try {
			file.createNewFile();
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(persistence.getDefaultContent().getDefaultContent());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {

			}
		}
	}

	private void update(IPersistence<T> persistence) {
		try {
			persistence.load(persistence.getDefaultContent().getName());
			persistence.save();
		} catch (FileNotFoundException e) {

		}
	}
}
