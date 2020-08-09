package fr.pederobien.minecraftgameplateform.pltf.commands;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftgameplateform.dictionary.EPlateformMessageCode;
import fr.pederobien.minecraftgameplateform.impl.editions.AbstractParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.pltf.IPlateformConfiguration;
import fr.pederobien.minecraftgameplateform.pltf.persistence.PlateformPersistence;

public class PlateformParent extends AbstractParentPersistenceEdition<IPlateformConfiguration> {

	public PlateformParent(Plugin plugin) {
		super("pltf", EPlateformMessageCode.PLATEFORM__EXPLANATION, plugin, PlateformPersistence.getInstance());
		addEdition(PlateformEditionFactory.rules().setModifiable(false));
	}
}
