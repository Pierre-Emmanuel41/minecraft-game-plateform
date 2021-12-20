package fr.pederobien.minecraft.game.platform.entries.simple;

import java.util.Optional;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.pederobien.minecraft.game.platform.entries.PlateformEntry;
import fr.pederobien.minecraft.game.platform.interfaces.element.ITeam;
import fr.pederobien.minecraftmanagers.TeamManager;

public class TeamPlayerOnModeEntry extends PlateformEntry {
	private ITeam team;
	private GameMode mode;
	private boolean colored;

	/**
	 * Create an entry that display the number of player in the given team that have the given game mode.
	 * 
	 * @param score   The line number of this entry.
	 * @param team    The team associated to this entry.
	 * @param mode    The player game mode used to filter team players.
	 * @param colored True if the team name is colored, false otherwise.
	 */
	public TeamPlayerOnModeEntry(int score, ITeam team, GameMode mode, boolean colored) {
		super(score);
		this.team = team;
		this.mode = mode;
		this.colored = colored;
	}

	@Override
	protected String updateCurrentValue(Player player) {
		Optional<Team> optTeam = getTeam().getServerTeam();
		return "" + (optTeam.isPresent() ? TeamManager.getNumberTeamPlayersOnMode(optTeam.get(), mode) : "");
	}

	/**
	 * @return The team associated to this entry.
	 */
	public ITeam getTeam() {
		return team;
	}

	/**
	 * 
	 * @return
	 */
	public GameMode getGameMode() {
		return mode;
	}

	@Override
	public final String getBefore() {
		String before = (colored ? team.getColor().getInColor(team.getName()) : team.getName()) + " : ";
		return before;
	}
}
