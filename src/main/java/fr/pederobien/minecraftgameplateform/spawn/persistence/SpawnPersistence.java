package fr.pederobien.minecraftgameplateform.spawn.persistence;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pederobien.minecraftdevelopmenttoolkit.utils.FileWriterHelper;
import fr.pederobien.minecraftgameplateform.impl.element.persistence.AbstractMinecraftPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldBlock;
import fr.pederobien.minecraftgameplateform.interfaces.element.persistence.IMinecraftPersistence;
import fr.pederobien.minecraftgameplateform.spawn.persistence.loaders.SpawnLoaderV10;
import fr.pederobien.minecraftgameplateform.utils.Plateform;

public class SpawnPersistence extends AbstractMinecraftPersistence<ISpawn> {
	private static final String ROOT_XML_DOCUMENT = "spawn";

	private SpawnPersistence() {
		super(Plateform.ROOT.resolve("Spawns"), "DefaultSpawn");
		register(new SpawnLoaderV10());
	}

	public static IMinecraftPersistence<ISpawn> getInstance() {
		return SingletonHolder.PERSISTENCE;
	}

	private static class SingletonHolder {
		public static final IMinecraftPersistence<ISpawn> PERSISTENCE = new SpawnPersistence();
	}

	@Override
	public void saveDefault() {
		FileWriterHelper.write(getAbsolutePath(getDefault()), new DefaultSpawnContent().get());
	}

	@Override
	public boolean save() {
		if (get() == null)
			return false;
		Document doc = newDocument();
		doc.setXmlStandalone(true);
		Element root = createElement(doc, ROOT_XML_DOCUMENT);
		doc.appendChild(root);

		Element version = createElement(doc, VERSION);
		version.appendChild(doc.createTextNode("" + getVersion()));
		root.appendChild(version);

		Element name = createElement(doc, SpawnXmlTag.NAME);
		name.appendChild(doc.createTextNode(get().getName()));
		root.appendChild(name);

		Element world = createElement(doc, SpawnXmlTag.WORLD);
		world.appendChild(doc.createTextNode(get().getWorld().getName()));
		root.appendChild(world);

		Element dimensions = createElement(doc, SpawnXmlTag.DIMENSIONS);
		setAttribute(dimensions, SpawnXmlTag.WIDTH, get().getWidth());
		setAttribute(dimensions, SpawnXmlTag.HEIGHT, get().getHeight());
		setAttribute(dimensions, SpawnXmlTag.DEPTH, get().getDepth());
		root.appendChild(dimensions);

		Element center = createElement(doc, SpawnXmlTag.CENTER);
		addCoordinates(center, get().getCenter().getX(), get().getCenter().getY(), get().getCenter().getZ());
		root.appendChild(center);

		Element playerSpawn = createElement(doc, SpawnXmlTag.PLAYER_SPAWN);
		addCoordinates(playerSpawn, get().getRelativePlayerSpawn().getX(), get().getRelativePlayerSpawn().getY(), get().getRelativePlayerSpawn().getZ());
		root.appendChild(playerSpawn);

		Element allowMobsUnderSpawn = createElement(doc, SpawnXmlTag.ALLOW_MOBS_UNDER_SPAWN);
		allowMobsUnderSpawn.appendChild(doc.createTextNode("" + get().isAllowMobsUnderSpawn()));
		root.appendChild(allowMobsUnderSpawn);

		Element blocks = createElement(doc, SpawnXmlTag.BLOCKS);
		for (IWorldBlock b : get().getBlocks()) {
			Element block = createElement(doc, SpawnXmlTag.BLOCK);
			addCoordinates(block, b.getX(), b.getY(), b.getZ());
			setAttribute(block, SpawnXmlTag.BLOCK_DATA, b.getBlockData().getAsString());
			blocks.appendChild(block);
		}
		root.appendChild(blocks);

		saveDocument(doc, get().getName());
		return true;
	}

	private void addCoordinates(Element element, Object xCoordinate, Object yCoordinate, Object zCoordinate) {
		setAttribute(element, SpawnXmlTag.X_COORDINATES, xCoordinate);
		setAttribute(element, SpawnXmlTag.Y_COORDINATES, yCoordinate);
		setAttribute(element, SpawnXmlTag.Z_COORDINATES, zCoordinate);
	}
}
