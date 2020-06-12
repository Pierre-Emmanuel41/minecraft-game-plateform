package fr.pederobien.minecraftgameplateform.entries.simple;

import java.time.LocalTime;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.entries.EEntryMessageCode;

public class GameTimeEntry extends TimeTaskEntry {

	/**
	 * Create an entry. This entry displays the time elapsed from the beginning of the game minus the time when the game is paused..
	 * 
	 * @param score The line number of this entry in the player objective.
	 */
	public GameTimeEntry(int score) {
		super(score);
	}

	@Override
	public LocalTime getTime() {
		return getTask().getGameTime();
	}

	@Override
	protected IMinecraftMessageCode getBeforeAsCode(Player player) {
		return EEntryMessageCode.GAME_TIME;
	}
}
