package fr.pederobien.minecraft.game.platform.entries.simple;

import java.time.LocalTime;

import org.bukkit.entity.Player;

import fr.pederobien.minecraft.game.platform.entries.EEntryMessageCode;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;

public class PauseTimeEntry extends TimeTaskEntry {

	/**
	 * Create an entry. This entry displays the time elapsed when the game is paused.
	 * 
	 * @param score The line number of this entry in the player objective.
	 */
	public PauseTimeEntry(int score) {
		super(score);
	}

	@Override
	public LocalTime getTime() {
		return getTask().getPauseTime();
	}

	@Override
	protected IMinecraftMessageCode getBeforeAsCode(Player player) {
		return EEntryMessageCode.PAUSE_TIME;
	}
}
