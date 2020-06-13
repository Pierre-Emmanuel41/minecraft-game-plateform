package fr.pederobien.minecraftgameplateform.interfaces.element;

import fr.pederobien.minecraftscoreboards.interfaces.IObjective;

public interface IGameObjective<T extends IGameConfiguration> extends IObjective {

	void initiate();

	void start();

	void pause();

	void relaunch();

	void stop();

	T getConfiguration();
}
