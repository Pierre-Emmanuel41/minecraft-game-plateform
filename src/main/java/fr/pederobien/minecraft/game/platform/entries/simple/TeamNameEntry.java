package fr.pederobien.minecraft.game.platform.entries.simple;

import java.util.Optional;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import fr.pederobien.minecraft.managers.TeamManager;
import fr.pederobien.minecraft.scoreboards.impl.CodeEntry;

public class TeamNameEntry extends CodeEntry {
	private boolean colored;

	/**
	 * Create an entry that displays the player team name. If any team has been found, the symbol "?" is displayed.
	 * 
	 * @param score   The line number of this entry.
	 * @param colored True if the team name should be displayed in team color, false otherwise.
	 */
	public TeamNameEntry(int score, boolean colored) {
		super(score);
		this.colored = colored;
	}

	@Override
	protected String updateCurrentValue(Player player) {
		Optional<Team> optTeam = TeamManager.getTeam(player);
		return !optTeam.isPresent() ? "?" : colored ? optTeam.get().getColor() + optTeam.get().getName() + ChatColor.RESET : optTeam.get().getName();
	}
}
