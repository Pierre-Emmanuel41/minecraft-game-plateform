package fr.pederobien.minecraftgameplateform.impl.editions;

import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdevelopmenttoolkit.impl.AbstractGenericParentEdition;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;

public class AbstractParentPersistenceEdition<T extends IUnmodifiableNominable> extends AbstractGenericParentEdition<IMessageCode, T, IParentPersistenceEdition<T>>
		implements IParentPersistenceEdition<T> {
	private IPersistence<T> persistence;

	public AbstractParentPersistenceEdition(String label, IMessageCode explanation, Plugin plugin, IPersistence<T> persistence) {
		super(label, explanation, new ParentPersistenceHelper<T>(plugin));
		this.persistence = persistence;
	}

	@Override
	public T get() {
		return getPersistence().get();
	}

	@Override
	public void set(T element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IPersistence<T> getPersistence() {
		return persistence;
	}
}
