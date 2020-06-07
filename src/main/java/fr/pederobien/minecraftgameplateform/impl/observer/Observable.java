package fr.pederobien.minecraftgameplateform.impl.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import fr.pederobien.minecraftgameplateform.interfaces.observer.IObservable;

public class Observable<T> implements IObservable<T> {
	private List<T> observers, tempAddObserver, tempRemoveObserver;
	private boolean isNotifying, addObserverFlag, removeObserverFlag;

	public Observable() {
		observers = new ArrayList<T>();
		tempAddObserver = new ArrayList<T>();
		tempRemoveObserver = new ArrayList<T>();
	}

	@Override
	public void addObserver(T obs) {
		if (!isNotifying) {
			observers.add(obs);
			return;
		}
		addObserverFlag = true;
		tempAddObserver.add(obs);
	}

	@Override
	public void removeObserver(T obs) {
		if (!isNotifying) {
			observers.remove(obs);
			return;
		}

		removeObserverFlag = true;
		tempRemoveObserver.add(obs);
	}

	@Override
	public void notifyObservers(Consumer<T> consumer) {
		if (size() > 0)
			internalNotify(observers.stream(), consumer);
	}

	@Override
	public void notifyObservers(Predicate<T> predicate, Consumer<T> consumer) {
		if (size() > 0)
			internalNotify(observers.stream().filter(predicate), consumer);
	}

	@Override
	public int size() {
		return observers.size();
	}

	private void internalNotify(Stream<T> observers, Consumer<T> consumer) {
		isNotifying = true;
		observers.forEach(consumer);
		isNotifying = false;
		if (addObserverFlag) {
			tempAddObserver.forEach(obs -> this.observers.add(obs));
			tempAddObserver.clear();
			addObserverFlag = false;
		}
		if (removeObserverFlag) {
			tempRemoveObserver.forEach(obs -> this.observers.remove(obs));
			tempRemoveObserver.clear();
			removeObserverFlag = false;
		}
	}
}
