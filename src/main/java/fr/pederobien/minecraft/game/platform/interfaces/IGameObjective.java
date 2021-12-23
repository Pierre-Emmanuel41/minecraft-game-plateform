package fr.pederobien.minecraft.game.platform.interfaces;

import fr.pederobien.minecraft.game.interfaces.IGame;
import fr.pederobien.minecraft.scoreboards.interfaces.IObjective;

public interface IGameObjective<T extends IGame> extends IObjective {

	void initiate();

	void start();

	void pause();

	void relaunch();

	void stop();

	T getGame();
}
