package fr.pederobien.minecraftgameplateform.entries.simple;

import java.time.LocalTime;

import org.bukkit.entity.Player;

import fr.pederobien.minecraftgameplateform.border.IBorderConfiguration;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.minecraftmanagers.WorldManager;

public class WorldBorderCountDown extends TimeTaskEntry {
	private IBorderConfiguration configuration;

	public WorldBorderCountDown(int score, IBorderConfiguration configuration) {
		super(score);
		this.configuration = configuration;
	}

	@Override
	public LocalTime getTime() {
		return configuration.getStartTime().minusSeconds(Plateform.getTimeTask().getGameTime().toSecondOfDay());
	}

	@Override
	public String getBefore(Player player) {
		return WorldManager.getWorldNameNormalised(configuration.getWorld()) + " : ";
	}
}
