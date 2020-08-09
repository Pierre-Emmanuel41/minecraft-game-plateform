package fr.pederobien.minecraftgameplateform.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import fr.pederobien.minecraftgameplateform.impl.observer.Observable;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameRule;
import fr.pederobien.minecraftgameplateform.interfaces.element.IGameRuleHelper;
import fr.pederobien.minecraftgameplateform.interfaces.observer.IObsGameRuleHelper;
import fr.pederobien.minecraftgameplateform.interfaces.observer.IObservable;

public class GameRuleHelper implements IGameRuleHelper {
	private Map<String, IGameRule<?>> rules;
	private IObservable<IObsGameRuleHelper> observable;

	private GameRuleHelper() {
		rules = new HashMap<String, IGameRule<?>>();
		observable = new Observable<IObsGameRuleHelper>();
	}

	public static IGameRuleHelper getInstance() {
		return SingletonHolder.HELPER;
	}

	private static class SingletonHolder {
		public static final IGameRuleHelper HELPER = new GameRuleHelper();
	}

	@Override
	public <T> void register(IGameRule<T> rule) {
		rules.put(rule.getName(), rule);
		observable.notifyObservers(o -> o.onGameRuleAdded(rule));
	}

	@Override
	public boolean unregister(String ruleName) {
		IGameRule<?> rule = rules.remove(ruleName);
		if (rule == null)
			return false;

		observable.notifyObservers(o -> o.onGameRuleAdded(rule));
		return true;
	}

	@Override
	public List<IGameRule<?>> getRules() {
		return Collections.unmodifiableList(new ArrayList<>(rules.values()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Optional<IGameRule<T>> getRule(String ruleName) {
		return Optional.ofNullable((IGameRule<T>) rules.get(ruleName));
	}

	/**
	 * Adds an observer to this game rule helper.
	 * 
	 * @param obs The observer to add.
	 */
	public void addObserver(IObsGameRuleHelper obs) {
		observable.addObserver(obs);
	}

	/**
	 * Removes an observer from this game rule helper.
	 * 
	 * @param obs The observer to remove.
	 */
	public void removeObserver(IObsGameRuleHelper obs) {
		observable.removeObserver(obs);
	}
}
