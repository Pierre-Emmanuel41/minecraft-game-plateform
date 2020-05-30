package fr.pederobien.minecraftgameplateform.impl.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGame;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;

public class GameConfiguration extends AbstractNominable implements IGameConfiguration {
	private IGame game;
	private List<ITeam> teams;

	protected GameConfiguration(String name, IGame game) {
		super(name);
		teams = new ArrayList<ITeam>();
	}

	@Override
	public IGame getGame() {
		return game;
	}

	@Override
	public List<ITeam> getTeams() {
		return Collections.unmodifiableList(teams);
	}

	@Override
	public Optional<ITeam> getTeam(String name) {
		for (ITeam team : teams)
			if (team.getName().equals(name))
				return Optional.of(team);
		return Optional.empty();
	}

	@Override
	public void add(ITeam team) {
		teams.add(team);
	}

	@Override
	public void remove(ITeam team) {
		teams.remove(team);
	}

	@Override
	public void removeTeams(List<ITeam> teams) {
		teams.removeAll(teams);
	}

	@Override
	public List<ITeam> clearTeams() {
		List<ITeam> removedTeams = new ArrayList<ITeam>(teams);
		teams.clear();
		return removedTeams;
	}

	/**
	 * If the given object is null then <code>"(default value)"</code> is added to parameter <code>display</code>.
	 * 
	 * @param object  The object to check.
	 * @param display The return value to modify or not.
	 * @return A string.
	 */
	protected String display(Object object, String display) {
		return display.concat(object == null ? " (default value)" : "");
	}
}
