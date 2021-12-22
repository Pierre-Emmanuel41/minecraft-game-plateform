package fr.pederobien.minecraft.game.platform.interfaces.element;

import fr.pederobien.minecraft.game.interfaces.IGameConfiguration;
import fr.pederobien.minecraftscoreboards.interfaces.IObjective;

public interface IGameObjective<T extends IGameConfiguration> extends IObjective {

	void initiate();

	void start();

	void pause();

	void relaunch();

	void stop();

	T getConfiguration();
}
