package fr.pederobien.minecraftgameplateform.entry.simple;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftdevelopmenttoolkit.utils.DisplayHelper;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.EGameMessageCode;

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
	protected String updateCurrentValue(Player player) {
		return DisplayHelper.toString(getTask().getPauseTime(), false);
	}

	@Override
	protected IMinecraftMessageCode getBeforeAsCode(Player player) {
		return EGameMessageCode.PAUSE_TIME;
	}
}
