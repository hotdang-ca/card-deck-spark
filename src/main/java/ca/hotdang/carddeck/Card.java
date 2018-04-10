package ca.hotdang.carddeck;

public class Card {
    // REFERENCE: https://en.wikipedia.org/wiki/Standard_52-card_deck

    public enum Suit {
        Spades, Clubs, Hearts, Diamonds
    }

    public enum Rank {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }

    private static String spadeSymbol = "♠";
    private static String heartSymbol = "♥";
    private static String diamondSymbol = "♦";
    private static String clubSymbol = "♣";

    /**
     * Describes the card suit
     */
    public Suit suit;

    /**
     * Describes the card rank
     */
    public Rank rank;

    /**
     * Standard Instantiator for a Card
     * @param suit - What suit (from enum)
     * @param rank - What rank (from enum)
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Returns full description of card in short notation
     * @return
     */
    public String toShortString() {
        String suitName = this.getSuitName(true);
        String rankName = this.getRankName(true);

        return String.format("%s%s", rankName, suitName);
    }

    /**
     * Returns full description fo the card in long notation
     * @return
     */
    public String toLongString() {
        String suitName = this.getSuitName(false);
        String rankName = this.getRankName(false);

        return String.format("%s of %s", rankName, suitName);
    }


    /**
     * Returns the suit of the card
     * @param isShortName - are we describing the short desc or the long desc?
     * @return
     */
    private String getSuitName(boolean isShortName) {
        switch (this.suit) {
            case Spades:
                return isShortName ? spadeSymbol : "Spades";
            case Clubs:
                return isShortName ? clubSymbol : "Clubs";
            case Hearts:
                return isShortName ? heartSymbol : "Hearts";
            case Diamonds:
                return isShortName ? diamondSymbol : "Diamonds";
        }

        return null;
    }

    /**
     * Returns the rank of the card
     * @param isShortName - are we describing hte short desc or the long desc?
     * @return
     */
    private String getRankName(boolean isShortName) {
        switch (this.rank) {
            case Ace:
                return isShortName ? "A" : "Ace";
            case Two:
                return isShortName ? "2" : "Two";
            case Three:
                return isShortName ? "3" : "Three";
            case Four:
                return isShortName ? "4" : "Four";
            case Five:
                return isShortName ? "5" : "Five";
            case Six:
                return isShortName ? "6" : "Six";
            case Seven:
                return isShortName ? "7" : "Seven";
            case Eight:
                return isShortName ? "8" : "Eight";
            case Nine:
                return isShortName ? "9" : "Nine";
            case Ten:
                return isShortName ? "10" : "Ten";
            case Jack:
                return isShortName ? "J" : "Jack";
            case Queen:
                return isShortName ? "Q" : "Queen";
            case King:
                return isShortName ? "K" : "King";
        }

        return null;
    }

    //TODO: hash for isEqual, etc
}
