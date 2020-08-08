package fr.pederobien.minecraftgameplateform.interfaces.element;

import java.util.List;
import java.util.Optional;

public interface IGameRuleHelper {

	/**
	 * Register the given rule in this game rule manager.
	 * 
	 * @param <T>  The object type the game rule is in charge of.
	 * @param rule The rule to register.
	 */
	<T> void register(IGameRule<T> rule);

	/**
	 * Unregister the game rule associated to the given name.
	 * 
	 * @param ruleName The game rule name to unregister.
	 * 
	 * @return true if the game rule has been found, false otherwise.
	 */
	boolean unregister(String ruleName);

	/**
	 * @return a list of all registered game rule. This list is unmodifiable.
	 */
	List<IGameRule<?>> getRules();

	/**
	 * Get the game rule associated to the given name.
	 * 
	 * @param <T>      The object type the game rule is in charge of.
	 * @param ruleName The game rule name.
	 * @return An optional that contains the game rule associated to the given name if it is registered, an empty optional otherwise.
	 */
	<T> Optional<IGameRule<T>> getRule(String ruleName);
}
