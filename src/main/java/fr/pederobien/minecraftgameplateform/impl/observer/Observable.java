package fr.pederobien.minecraftgameplateform.impl.observer;

import java.util.ArrayList;
import java.util.Collections;
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

	@Override
	public List<T> getObservers() {
		return Collections.unmodifiableList(observers);
	}

	private void internalNotify(Stream<T> observers, Consumer<T> consumer) {
		isNotifying = true;
		observers.forEach(obj -> {
			try {
				consumer.accept(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
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
