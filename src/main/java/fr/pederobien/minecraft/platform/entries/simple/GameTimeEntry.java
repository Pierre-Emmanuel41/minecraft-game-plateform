package fr.pederobien.minecraft.platform.entries.simple;

import java.time.LocalTime;

import org.bukkit.entity.Player;

import fr.pederobien.minecraft.dictionary.interfaces.IMinecraftCode;
import fr.pederobien.minecraft.platform.Platform;
import fr.pederobien.minecraft.platform.impl.EPlatformCode;

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
		return Platform.get(getObjective().getPlugin()).getTimeLine().getTimeTask().getGameTime();
	}

	@Override
	protected IMinecraftCode getBeforeAsCode(Player player) {
		return EPlatformCode.ENTRY__GAME_TIME;
	}
}
