package fr.pederobien.minecraftgameplateform.interfaces.observer;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 
 * @author Pierre-Emmanuel
 *
 * @param <T> The type of observer for this observable object.
 */
public interface IObservable<T> {

	/**
	 * Append an observer to this observable object.
	 * 
	 * @param obs The observer to add.
	 */
	void addObserver(T obs);

	/**
	 * Removes the given observers from the list of observer for this observable object.
	 * 
	 * @param obs The observer to remove.
	 */
	void removeObserver(T obs);

	/**
	 * Notify each observer that something has changed.
	 * 
	 * @param consumer The consumer used to know which method should be called on each observer.
	 */
	void notifyObservers(Consumer<T> consumer);

	/**
	 * Notify each observer that something has changed.
	 * 
	 * @param predicate A condition for each observer to be notified.
	 * @param consumer  The consumer used to know which method should be called on each observer.
	 */
	void notifyObservers(Predicate<T> predicate, Consumer<T> consumer);
}
