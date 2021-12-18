package fr.pederobien.minecraft.gameplateform.commands.common;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import fr.pederobien.minecraft.gameplateform.impl.editions.AbstractLabelEdition;
import fr.pederobien.minecraftdictionary.interfaces.IMinecraftMessageCode;
import fr.pederobien.persistence.interfaces.IUnmodifiableNominable;

public abstract class CommonDetails<T extends IUnmodifiableNominable> extends AbstractLabelEdition<T> {
	private IMinecraftMessageCode detailsCode;

	protected CommonDetails(IMinecraftMessageCode explanation, IMinecraftMessageCode detailsCode) {
		super(ECommonLabel.DETAILS, explanation);
		this.detailsCode = detailsCode;
	}

	@Override
	public final boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sendNotSynchro(sender, detailsCode, get().toString());
		return true;
	}
}
