# Presentation

This project gather tools for minecraft plugin development. It gather the features provided by the project [minecraft-game](https://github.com/Pierre-Emmanuel41/minecraft-game.git) and those from [minecraft-scoreboards](https://github.com/Pierre-Emmanuel41/minecraft-scoreboards.git).  
Indeed, the first project proposes features in order to create, start, pause/resume and stop a game and the second project propose features in order to display information on player's screen using scoreboards.

The goal of this project is to propose tools in order to create, save, load and modify a minecraft game. To do this, a <code>PlatformPersistence</code>  is available for developers. This persistence is associated to a specific folder in which configuration files are stored. Let's reuse the example  from the project [minecraft-command-tree](https://github.com/Pierre-Emmanuel41/minecraft-command-tree/blob/1.0_MC_1.16.5-SNAPSHOT/Tutorial.md) but the <code>Person</code> class should implements the <code>INominable</code> interface:

```java
// Folder for Person configuration files
Path folder = Paths.get("Person");

// Person creator
Function<String, Person> creator = name -> new Person(name, null);

// The persistence that really serialize and deserialize person configuration files
XmlPersistence<Person> xmlPersistence = Persistences.xmlPersistence();

// Action to perform when person with default parameters is saved
Consumer<Person> writeDefault = person -> {
	// Do nothing
};

PlatformPersistence<Person> persistence = new PlatformPersistence<Person>(folder, creator, xmlPersistence, writeDefault);
```

This way, if the algorithm that saves and loads person configuration files should serialize additional information, a new serializer can be added to the <code>xmlPersistence</code> as explained [here](https://github.com/Pierre-Emmanuel41/persistence/blob/master/Example.md). Once this persistence is created, it can be used by already implemented command in order to create, load, save, delete Person configuration files. All this commands can be found in the <code>PersistenceNodeFactory</code> class. 

Finally when a game is started, a <code>Platform</code> is automatically created in order to propose a timeline on which plugins can register in order to perform punctually or periodically actions. It also proposes an <code>IObjectiveUpdater</code> in order to update the scoreboard of players.
When a game is stopped, the platform is destroyed.