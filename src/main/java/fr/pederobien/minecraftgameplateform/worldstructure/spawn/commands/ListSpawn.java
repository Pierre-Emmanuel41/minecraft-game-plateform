package fr.pederobien.minecraftgameplateform.worldstructure.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.configurations.CommonList;
import fr.pederobien.minecraftgameplateform.dictionary.messages.worldstructure.spawn.ESpawnMessageCode;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;

public class ListSpawn extends CommonList<ISpawn> {

	protected ListSpawn() {
		super(ESpawnMessageCode.LIST_SPAWN__EXPLANATION);
	}

	@Override
	protected void onNoElement(CommandSender sender) {
		sendMessageToSender(sender, ESpawnMessageCode.LIST_SPAWN__NO_ELEMENT);
	}

	@Override
	protected void onOneElement(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.LIST_SPAWN__ONE_ELEMENT, name);
	}

	@Override
	protected void onSeveralElement(CommandSender sender, String names) {
		sendMessageToSender(sender, ESpawnMessageCode.LIST_SPAWN__SEVERAL_ELEMENTS, names);
	}
}
