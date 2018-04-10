# Deck of Cards
## A Spark Java Project

## What is this?
I was asked to do a code test for a scenario, whose text will remain anonymous (so that others do not google-search my repository).

The project is written in Java; see below for class descriptions. The Main class itself is a SparkJava class which can be run once built.

## Getting Started
This project is written with Maven in mind, and the Main solution is a SparkJava web server.

You'll need at least:

- Maven
- Java 1.8+

Drop into a shell in the main project directory, and issue the maven package command:

```shell
mvn package
```

You'll see some expected results:

```shell
[INFO] Building jar: <path-to>/target/card-deck-1.0-SNAPSHOT.jar

[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.098 s
[INFO] Finished at: 2018-04-10T12:10:06-06:00
[INFO] Final Memory: 26M/305M
[INFO] ------------------------------------------------------------------------
```

Then, run:

```shell
java -cp target/card-deck-1.0-SNAPSHOT.jar ca.hotdang.card-deck.Main
```

Or, open the solution in IntelliJ IDEA, and run the "Spark Server" task. Actually, that should be fine.

## Endpoints
Provided you get the solution running the following endpoints provide functionality:

`GET /deck/` - shows you the current deck

`GET /deck/new` - discards the current deck, and creates a new, ordered deck (fresh out of the package!)

`GET /deck/shuffle` - shuffles the deck, returns the current state of the deck

`GET /deck/describe/` - I love this one... rather than returning a deck, this describes the current deck in either long or short format.
To get the short format, include url param `type=short`.

## Testing
Testing can be done in IntelliJ IDEA by running the "All Tests" task. I'm sure maven can do it, but ... I can't figure out how _yet_.

## TODO
• Include the Joker cards.
• Keep track of multiple decks (currently there is just one server-instance deck)
• 
## License