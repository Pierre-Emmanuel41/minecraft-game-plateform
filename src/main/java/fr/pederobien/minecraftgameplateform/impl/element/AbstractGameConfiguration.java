package fr.pederobien.minecraftgameplateform.impl.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import fr.pederobien.minecraftgameplateform.interfaces.element.IGame;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;

public abstract class AbstractGameConfiguration extends AbstractNominable implements IGameConfiguration {
	private static final Long DEFAULT_SCOREBOARD_REFRESH = 5L;

	private IGame game;
	private List<ITeam> teams;
	private Long scoreboardRefresh;

	protected AbstractGameConfiguration(String name, IGame game) {
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
	public Long getScoreboardRefresh() {
		return scoreboardRefresh == null ? DEFAULT_SCOREBOARD_REFRESH : scoreboardRefresh;
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
	public List<ITeam> clear() {
		List<ITeam> removedTeams = new ArrayList<ITeam>(teams);
		teams.clear();
		return removedTeams;
	}

	@Override
	public void setScoreboardRefresh(long refresh) {
		this.scoreboardRefresh = refresh;
	}
}
