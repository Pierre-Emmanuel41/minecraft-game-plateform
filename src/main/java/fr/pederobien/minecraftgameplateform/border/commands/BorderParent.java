package fr.pederobien.minecraftgameplateform.border.commands;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.border.messages.EBorderMessageCode;
import fr.pederobien.minecraftgameplateform.border.persistence.BorderPersistence;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IBorderConfiguration;

public class BorderParent extends AbstractParentPersistenceEdition<IBorderConfiguration> {

	public BorderParent(Plugin plugin) {
		super("border", EBorderMessageCode.BORDER__EXPLANATION, plugin, BorderPersistence.getInstance());

		addEdition(BorderEditionsFactory.newBorder().setModifiable(false));
		addEdition(BorderEditionsFactory.currentBorder());
	}
}
