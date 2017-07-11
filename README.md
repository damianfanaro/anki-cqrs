### Anki Game

Anki is the Japanese word for **_memorization_**. For more information [click here](https://en.wikipedia.org/wiki/Anki_(software)).

`Important`

This version of the Anki Game was built on top of the [first one](https://github.com/damianfanaro/anki). 
The idea was to achieve exactly the same business logic but applying the [CQRS](https://martinfowler.com/bliki/CQRS.html) 
architectural pattern in order to separate the user's commands from the queries.

This version use [Axon Framework](http://www.axonframework.org/) in order to make the development easier
and ensure that CQRS principles are followed in the right way.

#### Prerequisites:

> ♨ Java 1.8+ (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

> ☉ Maven 3.5+ (https://maven.apache.org/download.cgi)

#### To generate distributable files run:

``mvn clean package assembly:single``

The generated files can be found inside the `target` folder.

The folder structure within the distributable file is:

```
anki-dfanaro-dist.[ zip | tar.gz ]
    .
    ├── ANKI-PROGRAM.md
    ├── README.md
    ├── bin
    │   └── anki-dfanaro-jar-with-dependencies.jar
    ├── box
    │   ├── green
    │   ├── orange
    │   └── red
    ├── deck
    │   └── deck
    ├── runner.sh
    └── sources
        ├── assembly
        ├── pom.xml
        └── src
```

#### Running:

To play the game just run the `runner.sh` script.

It will load the cards from the `deck` file. You can edit this file and add your cards.

Every line in the `deck` file correspond to a card with the following form:

`some question | some answer`

> Invalid lines will be ignored

#### Notes:

- This application does not contain special dependencies except for JUnit and Mockito for testing purposes.
- For simplicity, it just interacts with the user through the standard output stream in the display. 
