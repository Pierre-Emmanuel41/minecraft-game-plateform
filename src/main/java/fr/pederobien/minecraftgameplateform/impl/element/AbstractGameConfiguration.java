package fr.pederobien.minecraftgameplateform.impl.element;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import fr.pederobien.minecraftgameplateform.impl.observer.Observable;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;
import fr.pederobien.minecraftgameplateform.interfaces.observer.IObsGameConfiguration;

public abstract class AbstractGameConfiguration extends AbstractNominable implements IGameConfiguration {
	private static final LocalTime DEFAULT_PVP_TIME = LocalTime.of(0, 0, 0);
	private List<ITeam> teams;
	private LocalTime pvpTime;
	private Observable<IObsGameConfiguration> observers;

	protected AbstractGameConfiguration(String name) {
		super(name);
		teams = new ArrayList<ITeam>();
		observers = new Observable<>();
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
	public LocalTime getPvpTime() {
		return pvpTime == null ? DEFAULT_PVP_TIME : pvpTime;
	}

	@Override
	public void add(ITeam team) {
		teams.add(team);
		observers.notifyObservers(obs -> obs.onTeamAdded(this, team));
	}

	@Override
	public void remove(ITeam team) {
		if (!teams.contains(team))
			return;

		team.clear();
		teams.remove(team);
		observers.notifyObservers(obs -> obs.onTeamRemoved(this, team));
	}

	@Override
	public void removeTeams(List<ITeam> teams) {
		teams.forEach(team -> remove(team));
	}

	@Override
	public List<ITeam> clearTeams() {
		List<ITeam> removedTeams = new ArrayList<ITeam>(teams);
		teams.clear();
		return removedTeams;
	}

	@Override
	public void setPvpTime(LocalTime pvpTime) {
		LocalTime oldTime = this.pvpTime;
		observers.notifyObservers(obs -> obs.onPvpTimeChanged(this, oldTime, this.pvpTime = pvpTime));
	}

	@Override
	public void addObserver(IObsGameConfiguration obs) {
		observers.addObserver(obs);
	}

	@Override
	public void removeObserver(IObsGameConfiguration obs) {
		observers.removeObserver(obs);
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
