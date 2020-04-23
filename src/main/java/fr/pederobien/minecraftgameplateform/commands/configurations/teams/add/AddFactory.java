package fr.pederobien.minecraftgameplateform.commands.configurations.teams.add;

import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;

public class AddFactory {

	/**
	 * @return An edition to add teams to a configuration
	 */
	public static <T extends IGameConfiguration> IMapPersistenceEdition<T> addTeam() {
		return new AddTeam<T>();
	}
}
