package fr.pederobien.minecraft.game.platform.impl.element;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.game.platform.impl.observer.Observable;
import fr.pederobien.minecraft.game.platform.interfaces.element.IEventListener;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGame;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.element.IGameConfigurationContext;
import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;
import fr.pederobien.minecraft.game.platform.interfaces.observer.IObsGameConfiguration;
import fr.pederobien.minecraft.game.platform.interfaces.observer.IObsGameConfigurationContext;

public class GameConfigurationContext implements IGameConfigurationContext {
	private IGameConfiguration gameConfiguration;
	private Observable<IObsGameConfigurationContext> observers;

	private GameConfigurationContext() {
		observers = new Observable<IObsGameConfigurationContext>();
	}

	public static IGameConfigurationContext getInstance() {
		return SingletonHolder.CONTEXT;
	}

	private static class SingletonHolder {
		public static final IGameConfigurationContext CONTEXT = new GameConfigurationContext();
	}

	@Override
	public void add(ITeam team) {
		getGameConfiguration().add(team);
	}

	@Override
	public void remove(ITeam team) {
		getGameConfiguration().remove(team);
	}

	@Override
	public void removeTeams(List<ITeam> teams) {
		getGameConfiguration().removeTeams(teams);
	}

	@Override
	public List<ITeam> clearTeams() {
		return getGameConfiguration().clearTeams();
	}

	@Override
	public void setPvpTime(LocalTime pvpTime) {
		getGameConfiguration().setPvpTime(pvpTime);
	}

	@Override
	public void addObserver(IObsGameConfiguration obs) {
		getGameConfiguration().addObserver(obs);
	}

	@Override
	public void removeObserver(IObsGameConfiguration obs) {
		getGameConfiguration().removeObserver(obs);
	}

	@Override
	public void setName(String name) {
		getGameConfiguration().setName(name);
	}

	@Override
	public IGame getGame() {
		return getGameConfiguration().getGame();
	}

	@Override
	public List<ITeam> getTeams() {
		return getGameConfiguration().getTeams();
	}

	@Override
	public Optional<ITeam> getTeam(String name) {
		return getGameConfiguration().getTeam(name);
	}

	@Override
	public LocalTime getPvpTime() {
		return getGameConfiguration().getPvpTime();
	}

	@Override
	public String getName() {
		return getGameConfiguration().getName();
	}

	@Override
	public boolean initiate(CommandSender sender, Command command, String label, String[] args) {
		return getGame().initiate(sender, command, label, args);
	}

	@Override
	public void start() {
		getGame().start();
	}

	@Override
	public void stop() {
		getGame().stop();
	}

	@Override
	public void pause() {
		getGame().pause();
	}

	@Override
	public void relaunch() {
		getGame().relaunch();
	}

	@Override
	public IEventListener getListener() {
		return getGame().getListener();
	}

	@Override
	public void onPvpEnabled() {
		getGame().onPvpEnabled();
	}

	@Override
	public boolean isRunning() {
		return gameConfiguration == null ? false : getGame().isRunning();
	}

	@Override
	public void setGameConfiguration(IGameConfiguration gameConfiguration) {
		IGameConfiguration oldConfiguration = this.gameConfiguration;
		this.gameConfiguration = gameConfiguration;
		observers.notifyObservers(obs -> obs.onConfigurationChanged(oldConfiguration, getGameConfiguration()));
	}

	@Override
	public IGameConfiguration getGameConfiguration() {
		return gameConfiguration;
	}

	@Override
	public void addContextObserver(IObsGameConfigurationContext obs) {
		observers.addObserver(obs);
	}

	@Override
	public void removeContextObserver(IObsGameConfigurationContext obs) {
		observers.removeObserver(obs);
	}
}
