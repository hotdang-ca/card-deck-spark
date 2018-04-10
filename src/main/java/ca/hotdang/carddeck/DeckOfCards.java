package ca.hotdang.carddeck;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
    private ArrayList<Card> deck;

    /**
     * Standard Instantiator for a Deck of Cards
     */
    public DeckOfCards() {
        // need one of every type
        this.deck = this.orderedDeck();
    }

    /**
     * Generates a new ordered Deck of Cards
     * @return a deck of cards
     */
    private ArrayList<Card> orderedDeck() {
        ArrayList<Card> orderedDeck = new ArrayList<Card>();

        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank: Card.Rank.values()) {
                orderedDeck.add(new Card(suit, rank));
            }
        }

        return orderedDeck;
    }

    /**
     * Returns a deck, using an alternate description
     * @param isShortDescription - specify if you want a short description; otherwise long description is provided
     * @return ArrayList<String> - A described Deck
     */
    public ArrayList<String> getDescribedDeck(boolean isShortDescription) {
        if (this.deck == null) {
            this.deck = this.orderedDeck();
        }

        ArrayList<String> describedDeck = new ArrayList<>();
        this.deck.forEach((card) -> {
            describedDeck.add(isShortDescription ? card.toShortString() : card.toLongString());
        });

        return describedDeck;
    }


    /**
     * Returns length of the deck
     * @return int - Deck length
     */
    public int length() {
        if (this.deck != null) {
            return this.deck.size();
        }

        return 0;
    }

    /**
     * Returns the top card
     * @return
     */
    public Card getTopCard() {
        if (this.deck != null) {
            return this.deck.get(0);
        }

        return null;
    }

    public int indexOfCard(Card.Suit suit, Card.Rank rank) {
        int foundIndex = 0;
        for (Card findCard : this.deck) {
            if (findCard.suit == suit && findCard.rank == rank) {
                return foundIndex;
            }

            foundIndex++;
        }

        return -1;
    }

    /**
     * Returns the card at position specified
     */
    public Card getCardAtIndex(int position) {
        if (this.deck != null) {
            return this.deck.get(position);
        }

        return null;
    }

    /**
     * Remove the card at position specified
     */
    public Card dealCardAtIndex(int position) {
        if (this.deck != null) {
            Card dealtCard = this.deck.remove(0);
            return dealtCard;
        }

        return null;
    }

    /**
     * Shuffles the deck.
     * I was prepared to write an arraylist shuffler, but collections provide this functionality already :)
     * Why re-invent the wheel?
     */
    public void shuffle() {
        Collections.shuffle(this.deck);
    }
}
