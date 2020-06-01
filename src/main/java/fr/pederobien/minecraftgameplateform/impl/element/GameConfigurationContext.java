package fr.pederobien.minecraftgameplateform.impl.element;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import fr.pederobien.minecraftgameplateform.interfaces.element.IEventListener;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGame;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfiguration;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameConfigurationContext;
import fr.pederobien.minecraftgameplateform.interfaces.element.ITeam;

public class GameConfigurationContext implements IGameConfigurationContext {
	private IGameConfiguration gameConfiguration;

	private GameConfigurationContext() {
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
	public boolean initiate() {
		return getGame().initiate();
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
	public void setGameConfiguration(IGameConfiguration gameConfiguration) {
		this.gameConfiguration = gameConfiguration;
	}

	@Override
	public IGameConfiguration getGameConfiguration() {
		return gameConfiguration;
	}
}
