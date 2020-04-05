package fr.pederobien.minecraftgameplateform.worldstructure.spawn.persistence;

import java.nio.file.Paths;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import fr.pederobien.minecraftgameplateform.impl.element.persistence.xml.AbstractXmlPersistence;
import fr.pederobien.minecraftgameplateform.interfaces.element.ISpawn;
import fr.pederobien.minecraftgameplateform.interfaces.element.IWorldBlock;

public class SpawnPersistence extends AbstractXmlPersistence<ISpawn> {
	private static final String ROOT_XML_DOCUMENT = "spawn";
	private static final double CURRENT_VERSION = 1.0;

	protected SpawnPersistence() {
		super(ROOT.resolve(Paths.get("Spawns")), new DefaultSpawnContent());
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
		version.appendChild(doc.createTextNode("" + CURRENT_VERSION));
		root.appendChild(version);

		Element name = createElement(doc, SpawnXmlTag.NAME);
		name.appendChild(doc.createTextNode(get().getName()));
		root.appendChild(name);

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
