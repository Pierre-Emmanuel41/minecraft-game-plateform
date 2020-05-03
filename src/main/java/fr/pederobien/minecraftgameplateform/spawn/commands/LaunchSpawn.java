package fr.pederobien.minecraftgameplateform.spawn.commands;

import org.bukkit.command.CommandSender;

import fr.pederobien.minecraftgameplateform.commands.common.ECommonLabel;
import fr.pederobien.minecraftgameplateform.commands.worldstructure.CommonLaunch;
import fr.pederobien.minecraftgameplateform.commands.worldstructure.EWorldStructureLabel;
import fr.pederobien.minecraftgameplateform.interfaces.element.ILabel;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.spawn.messages.ESpawnMessageCode;

public class LaunchSpawn extends CommonLaunch<ISpawn> {

	public LaunchSpawn() {
		super(ESpawnMessageCode.LAUNCH_SPAWN__EXPLANATION);
	}

	@Override
	protected void onNoStructure(CommandSender sender) {
		sendMessageToSender(sender, ESpawnMessageCode.LAUNCH_SPAWN__NO_CURRENT_SPAWN);
	}

	@Override
	protected void onWorldIsMissing(CommandSender sender, String world) {
		sendMessageToSender(sender, ESpawnMessageCode.LAUNCH_SPAWN__WORLD_IS_MISSING, world);
	}

	@Override
	protected void onStructureDoesNotExist(CommandSender sender, String name) {
		sendMessageToSender(sender, ESpawnMessageCode.LAUNCH_SPAWN__SPAWN_DOES_NOT_EXIST, name);
	}

	@Override
	protected void onLaunched(CommandSender sender, String name, String world, int x, int y, int z) {
		sendMessageToSender(sender, ESpawnMessageCode.LAUNCH_SPAWN__SPAWN_LAUNCHED, name, world, x, y, z);
		get().getListener().register(getParent().getPlugin());
		get().getListener().setActivated(true);
		setAllAvailable();
	}

	private void setAllAvailable() {
		for (ILabel label : ECommonLabel.values())
			setAvailableLabelEdition(label);
		for (ILabel label : EWorldStructureLabel.values())
			setAvailableLabelEdition(label);
		for (ILabel laebl : ESpawnLabel.values())
			setAvailableLabelEdition(laebl);
	}
}
