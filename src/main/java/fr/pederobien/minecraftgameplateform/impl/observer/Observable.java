package fr.pederobien.minecraftgameplateform.impl.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import fr.pederobien.minecraftgameplateform.interfaces.observer.IObservable;

public class Observable<T> implements IObservable<T> {
	private List<T> observers;

	public Observable() {
		observers = new ArrayList<T>();
	}

	@Override
	public void addObserver(T obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver(T obs) {
		observers.remove(obs);
	}

	@Override
	public void notifyObservers(Consumer<T> consumer) {
		internalNotify(observers.stream(), consumer);
	}

	@Override
	public void notifyObservers(Predicate<T> predicate, Consumer<T> consumer) {
		internalNotify(observers.stream().filter(predicate), consumer);
	}

	@Override
	public int size() {
		return observers.size();
	}

	private void internalNotify(Stream<T> observers, Consumer<T> consumer) {
		observers.peek(consumer);
	}
}
