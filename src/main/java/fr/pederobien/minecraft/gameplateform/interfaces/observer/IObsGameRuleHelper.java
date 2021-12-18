package fr.pederobien.minecraft.gameplateform.interfaces.observer;

import fr.pederobien.minecraft.gameplateform.interfaces.element.IGameRule;

public interface IObsGameRuleHelper {

	/**
	 * Notify this observer a game rule has been added.
	 * 
	 * @param rule The added rule.
	 */
	void onGameRuleAdded(IGameRule<?> rule);

	/**
	 * Notify this observer a game rule has been removed.
	 * 
	 * @param rule The removed rule.
	 */
	void onGameRuleRemoved(IGameRule<?> rule);
}
