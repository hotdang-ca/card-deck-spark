# Deck of Cards
## A Spark Java Project

## What is this?

I was asked to do a code test for a scenario, whose text will remain anonymous (so that others do not google-search my repository).

The project is written in Java; see below for class descriptions. The Main class itself is a SparkJava class which can be run once built.

## Getting Started

This project is written with Maven in mind, and the Main solution is a SparkJava web server.

You'll need at least:

* Maven
* Java 1.8+

Nice to have:

* IntelliJ IDEA

Drop into a shell in the main project directory, and issue the Mojo maven compile command:

```shell
mvn compile exec:java
```

Or, open the solution in IntelliJ IDEA, and run the "Spark Server" task. 

## Endpoints

Provided you get the solution running the following endpoints provide functionality:

`GET /deck/` - shows you the current deck

`GET /deck/new` - discards the current deck, and creates a new, ordered deck (fresh out of the package!)

`GET /deck/shuffle` - shuffles the deck, returns the current state of the deck

`GET /deck/describe` - I love this one... rather than returning a deck, this describes the current deck in either long or short format.
To get the short format, include url param `type=short`.

`GET /deck/deal` - Deals a card. Output will be the card you were dealt. It will be removed from the internal instance (because it's now in the hands of a player, presumably).

## Testing

Testing can be done in IntelliJ IDEA by running the "All Tests" task. I'm sure maven can do it, but ... I can't figure out how _yet_.

## TODO

* Include the Joker cards
* Keep track of multiple decks (which can be namespaced in the url path)
* Deal all the cards until the deck is depleted of cards

## License

Copyright 2018 James Robert PErih

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

