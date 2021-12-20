package fr.pederobien.minecraft.game.platform.impl.element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Consumer;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Team;

import fr.pederobien.minecraft.game.platform.Platform;
import fr.pederobien.minecraft.game.platform.impl.observer.Observable;
import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;
import fr.pederobien.minecraft.game.platform.interfaces.observer.IObsTeam;
import fr.pederobien.minecraft.game.platform.interfaces.observer.IObservable;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftmanagers.EColor;
import fr.pederobien.minecraftmanagers.MessageManager;
import fr.pederobien.minecraftmanagers.TeamManager;

public class PlateformTeam extends AbstractNominable implements ITeam {
	private EColor color;
	private List<Player> players, quitPlayers;
	private IObservable<IObsTeam> observable;
	private boolean isCopy;
	private Team serverTeam;

	private PlateformTeam(String name, EColor color, boolean isCopy) {
		super(name);

		players = new ArrayList<Player>();
		quitPlayers = new ArrayList<Player>();
		observable = new Observable<IObsTeam>();

		setColor(color);
		this.isCopy = isCopy;

		Platform.getPlayerQuitOrJoinEventListener().addObserver(this);
	}

	/**
	 * Create a team with the give name and the specified color. The color cannot be null.
	 * 
	 * @param name  The name of the team.
	 * @param color The color of the team.
	 * 
	 * @return The created team.
	 */
	public static ITeam of(String name, EColor color) {
		return new PlateformTeam(name, color, false);
	}

	/**
	 * Create a team with the given name, its color is {@link EColor#RESET}.
	 * 
	 * @param name The name of the team.
	 * 
	 * @return The created team.
	 * 
	 * @see #of(String, EColor)
	 */
	public static ITeam of(String name) {
		return of(name, EColor.RESET);
	}

	@Override
	public void setName(String name) {
		String oldName = getName();
		super.setName(name);
		synchronizeWithServerTeam(serverTeam -> serverTeam.setDisplayName(name), obs -> obs.onNameChanged(this, oldName, getName()));
	}

	@Override
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		Iterator<Player> iterator = quitPlayers.iterator();
		while (iterator.hasNext()) {
			Player player = iterator.next();
			if (player.getName().equals(event.getPlayer().getName())) {
				removePlayer(player);
				iterator.remove();
				addPlayer(event.getPlayer());
			}
		}
	}

	@Override
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		for (Player player : players)
			if (player.getName().equals(event.getPlayer().getName()))
				quitPlayers.add(event.getPlayer());
	}

	@Override
	public String getColoredName() {
		return getColor().getInColor(getName());
	}

	@Override
	public EColor getColor() {
		return color;
	}

	@Override
	public List<Player> getPlayers() {
		return Collections.unmodifiableList(players);
	}

	@Override
	public void sendMessage(Player sender, String message) {
		for (Player player : players)
			MessageManager.sendMessage(player, getPrefix(sender, player) + message);
	}

	@Override
	public void sendMessage(Player sender, IMinecraftMessageCode code, Object... args) {
		for (Player player : players)
			MessageManager.sendMessage(player, getPrefix(sender, player) + getMessage(player, code, args));
	}

	@Override
	public Optional<Team> getServerTeam() {
		return TeamManager.getTeam(getName());
	}

	@Override
	public boolean isCreatedOnServer() {
		Optional<Team> optTeam = getServerTeam();
		if (optTeam.isPresent()) {
			serverTeam = optTeam.get();
			return true;
		}
		return false;
	}

	@Override
	public void setColor(EColor color) {
		Objects.requireNonNull(color, "The color is null");
		EColor oldColor = getColor();
		this.color = color;
		synchronizeWithServerTeam(serverTeam -> serverTeam.setColor(color.getChatColor()), obs -> obs.onColorChanged(this, oldColor, getColor()));
	}

	@Override
	public void addPlayer(Player player) {
		players.add(player);
		synchronizeWithServerTeam(serverTeam -> serverTeam.addEntry(player.getName()), obs -> obs.onPlayerAdded(this, player));
	}

	@Override
	public void removePlayer(Player player) {
		players.remove(player);
		synchronizeWithServerTeam(serverTeam -> serverTeam.removeEntry(player.getName()), obs -> obs.onPlayerRemoved(this, player));
	}

	@Override
	public void clear() {
		for (Player player : players) {
			synchronizeWithServerTeam(serverTeam -> serverTeam.removeEntry(player.getName()), obs -> obs.onPlayerRemoved(this, player));
		}
		players.clear();
	}

	@Override
	public ITeam clone() {
		ITeam team = new PlateformTeam(getName(), getColor(), true);
		for (Player player : getPlayers())
			team.addPlayer(player);
		observable.notifyObservers(obs -> obs.onClone(this));
		return team;
	}

	@Override
	public void addObserver(IObsTeam obs) {
		observable.addObserver(obs);
	}

	@Override
	public void removeObserver(IObsTeam obs) {
		observable.removeObserver(obs);
	}

	@Override
	public String toString() {
		StringJoiner players = new StringJoiner(" ", "[", "]");
		for (Player player : getPlayers())
			players.add(player.getName());
		return getColor().getInColor(getName() + " " + players.toString());
	}

	/**
	 * Update the server team with the consumer <code>team</code> and notify observers of this team with the consumer <code>obs</code>
	 * 
	 * @param team The consumer used to update the server team.
	 * @param obs  The consumer used to notify observers oh this team.
	 */
	private void synchronizeWithServerTeam(Consumer<Team> team, Consumer<IObsTeam> obs) {
		if (isCreatedOnServer() && !isCopy)
			team.accept(serverTeam);
		observable.notifyObservers(obs);
	}

	private String getPrefix(Player sender, Player player) {
		return color.getInColor("[" + (player.equals(sender) ? "me" : sender.getName()) + " -> " + getName() + "] ");
	}
}
