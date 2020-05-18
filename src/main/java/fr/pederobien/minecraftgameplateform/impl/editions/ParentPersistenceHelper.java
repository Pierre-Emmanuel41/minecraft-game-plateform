package fr.pederobien.minecraftgameplateform.impl.editions;

import java.util.List;
import java.util.StringJoiner;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import fr.pederobien.dictionary.interfaces.IDictionaryManager;
import fr.pederobien.minecraftdevelopmenttoolkit.impl.messagecode.AbstractMessageCodeHelper;
import fr.pederobien.minecraftdevelopmenttoolkit.interfaces.IGenericEdition;
import fr.pederobien.minecraftdictionary.impl.MinecraftMessageEvent;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.minecraftgameplateform.dictionary.ECommonMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IMapPersistenceEdition;
import fr.pederobien.minecraftgameplateform.interfaces.editions.IParentPersistenceEdition;
import fr.pederobien.minecraftgameplateform.utils.Plateform;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public class ParentPersistenceHelper<T extends IUnmodifiableNominable> extends AbstractMessageCodeHelper<T, IParentPersistenceEdition<T>, IMapPersistenceEdition<T>> {

	protected ParentPersistenceHelper() {
		super(ECommonMessageCode.COMMON_HELP_EXPLANATION);
	}

	@Override
	protected void sendMessage(Player player, List<IGenericEdition<IMinecraftMessageCode>> editions) {
		StringJoiner joiner = new StringJoiner("\n");
		for (IGenericEdition<IMinecraftMessageCode> edition : editions)
			joiner.add(translate(player, edition));
		sendMessage(player, joiner.toString());
	}

	private String translate(Player player, IGenericEdition<IMinecraftMessageCode> edition) {
		String explanation = ((IDictionaryManager) Plateform.getNotificationCenter().getDictionaryContext())
				.getMessage(new MinecraftMessageEvent(player, edition.getExplanation()));
		return ChatColor.DARK_RED + edition.getLabel() + " - " + ChatColor.DARK_AQUA + explanation + "\n";
	}
}
