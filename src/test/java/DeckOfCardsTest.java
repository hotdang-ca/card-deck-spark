import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    @Test
    void getDescribedDeck() {
        DeckOfCards testDeck = new DeckOfCards();
        ArrayList<String> describedShortDeck = testDeck.getDescribedDeck(true);
        ArrayList<String> describedLongDeck = testDeck.getDescribedDeck(false);

        String expectedLongSuitAtTop = "Spades";
        String expectedLongRankAtTop = "Ace";

        String expectedShortSuitAtTop = "♠";
        String expectedShortRankAtTop = "A";

        assertEquals(String.format("%s of %s", expectedLongRankAtTop, expectedLongSuitAtTop), describedLongDeck.get(0), "Top card described long matches");
        assertEquals(String.format("%s%s", expectedShortRankAtTop, expectedShortSuitAtTop), describedShortDeck.get(0), "Top card described short matches");
    }

    @Test
    void length() {
        DeckOfCards testDeck = new DeckOfCards();
        int expectedDeckLength = 52;
        assertEquals(expectedDeckLength, testDeck.length(), "Deck has 52 cards");
    }

    @Test
    void shuffle() {
        DeckOfCards testDeck = new DeckOfCards();

        Card firstCard = testDeck.getTopCard();

        // surely, after 5 shuffles, top card isn't the same anymore. How do you test random?
        testDeck.shuffle();
        testDeck.shuffle();
        testDeck.shuffle();
        testDeck.shuffle();
        testDeck.shuffle();

        assertNotEquals(firstCard, testDeck.getTopCard(), "Top card of new ordered deck no longer at top");
    }

    @Test
    void getTopCard() {
        DeckOfCards testDeck = new DeckOfCards();

        Card.Suit expectedSuit = Card.Suit.Spades;
        Card.Rank expectedRank = Card.Rank.Ace;

        Card topCard = testDeck.getTopCard();
        assertEquals(expectedSuit, topCard.suit, "Top Card Suit is Spades");
        assertEquals(expectedRank, topCard.rank, "Top Card Rank is Ace");
    }

    @Test
    void indexOfCard() {
        DeckOfCards testDeck = new DeckOfCards();

        int expectedIndex = 13;
        int actualIndex = testDeck.indexOfCard(Card.Suit.Clubs, Card.Rank.Ace);

        assertEquals(expectedIndex, actualIndex, "Index of new deck matches");
    }

    @Test
    void getCardAtIndex() {
        DeckOfCards testDeck = new DeckOfCards();
        Card expectedCard = new Card(Card.Suit.Diamonds, Card.Rank.King);
        Card actualCard = testDeck.getCardAtIndex(testDeck.length() - 1);

        assertEquals(expectedCard.suit, actualCard.suit, "Card suit at index in deck matches");
        assertEquals(expectedCard.rank, actualCard.rank, "Card rank at index in deck matches");
    }

    @Test
    void dealCardAtIndex() {
        DeckOfCards testDeck = new DeckOfCards();
        Card expectedCard = new Card(Card.Suit.Spades, Card.Rank.Ace);
        Card newTopCard = new Card(Card.Suit.Spades, Card.Rank.Two);

        Card actualCard = testDeck.dealCardAtIndex(0);

        assertEquals(expectedCard.suit, actualCard.suit, "Dealt card is first in a new deck by suit.");
        assertEquals(expectedCard.rank, actualCard.rank, "Dealt card is first in a new deck by rank.");
        assertEquals(51, testDeck.length(), "Deck of cards is short one Card.");
        assertEquals(-1, testDeck.indexOfCard(expectedCard.suit, expectedCard.rank), "Dealt card is not found in the deck.");

        assertEquals(newTopCard.suit, testDeck.getTopCard().suit, "New top card is spades");
        assertEquals(newTopCard.rank, testDeck.getTopCard().rank, "New top card is two");
    }
}