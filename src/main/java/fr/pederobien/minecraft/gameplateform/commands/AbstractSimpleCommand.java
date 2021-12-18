package fr.pederobien.minecraft.gameplateform.commands;

import org.bukkit.plugin.java.JavaPlugin;

import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.messagecode.IMessageCodeSimpleMapEdition;

public class AbstractSimpleCommand extends AbstractTabExecutorCommand<IMessageCodeSimpleMapEdition> {

	protected AbstractSimpleCommand(JavaPlugin plugin, IMessageCodeSimpleMapEdition parent) {
		super(plugin, parent.getLabel(), parent);
	}

}
