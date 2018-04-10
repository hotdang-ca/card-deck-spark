import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void toShortString() {
        Card card = new Card(Card.Suit.Clubs, Card.Rank.Two);
        String expectedResults = "2♣";

        assertEquals(card.toShortString(), expectedResults, "Short description matches");
    }

    @Test
    void toLongString() {
        Card card = new Card(Card.Suit.Hearts, Card.Rank.Queen);
        String expectedResults = "Queen of Hearts";
        assertEquals(card.toLongString(), expectedResults, "Long Description matches");
    }
}