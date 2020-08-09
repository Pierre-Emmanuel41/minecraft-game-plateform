package fr.pederobien.minecraftgameplateform.pltf.persistence;

import fr.pederobien.minecraftgameplateform.impl.element.persistence.AbstractMinecraftPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftgameplateform.pltf.IPlateformConfiguration;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class PlateformPersistence extends AbstractMinecraftPersistence<IPlateformConfiguration> {

	private PlateformPersistence() {
		super(Plateform.ROOT.resolve("Internal"), "DefaultPlateformConfiguration");
		set(Plateform.getConfiguration());
	}

	public static IMinecraftPersistence<IPlateformConfiguration> getInstance() {
		return SingletonHolder.PERSISTENCE;
	}

	private static class SingletonHolder {
		public static final IMinecraftPersistence<IPlateformConfiguration> PERSISTENCE = new PlateformPersistence();
	}

	@Override
	public void saveDefault() {
		save();
	}

	@Override
	public boolean save() {
		return true;
	}
}
