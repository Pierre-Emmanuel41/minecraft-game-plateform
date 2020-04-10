package fr.pederobien.minecraftgameplateform.impl.editions;

import java.util.List;
import java.util.StringJoiner;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.pederobien.minecraftdevelopmenttoolkit.impl.AbstractHelper;
import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.IGenericEdition;
import fr.pederobien.minecraftgameplateform.dictionary.messages.EMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IDictionaryManager;
import fr.pederobien.minecraftgameplateform.interfaces.dictionary.IMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.element.unmodifiable.IUnmodifiableNominable;
import fr.pederobien.minecraftgameplateform.utils.EventFactory;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class ParentPersistenceHelper<T extends IUnmodifiableNominable> extends AbstractHelper<IMessageCode, T, IParentPersistenceEdition<T>, IMapPersistenceEdition<T>> {
	private Plugin plugin;

	protected ParentPersistenceHelper(Plugin plugin) {
		super(EMessageCode.HELP_EXPLANATION);
		this.plugin = plugin;
	}

	@Override
	protected void sendMessage(Player player, List<IGenericEdition<IMessageCode>> editions) {
		StringJoiner joiner = new StringJoiner("\n");
		for (IGenericEdition<IMessageCode> edition : editions)
			joiner.add(translate(player, edition));
		sendMessage(player, joiner.toString());
	}

	private String translate(Player player, IGenericEdition<IMessageCode> edition) {
		String explanation = ((IDictionaryManager) Plateform.getNotificationCenter().getDictionaryContext())
				.getMessage(EventFactory.messageEvent(player, plugin, edition.getExplanation()));
		return ChatColor.DARK_RED + edition.getLabel() + " - " + ChatColor.DARK_AQUA + explanation + "\n";
	}
}
