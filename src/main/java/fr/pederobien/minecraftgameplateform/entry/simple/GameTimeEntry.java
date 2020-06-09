package fr.pederobien.minecraftgameplateform.entry.simple;

import java.time.LocalTime;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;

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
	protected LocalTime getTime() {
		return getTask().getGameTime();
	}

	@Override
	protected IMinecraftMessageCode getBeforeAsCode(Player player) {
		return EGameMessageCode.GAME_TIME;
	}
}
