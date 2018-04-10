package ca.hotdang;

import com.google.gson.Gson;
import static spark.Spark.*;

public class Main {

    /**
     * Which port we want the server to run
     */
    private static int PORT = 8080;

    /**
     * Standard JSON response header
     */
    private static String JSON_RESPONSE = "application/json";

    /**
     * Current server-instance of a single deck of cards
     */
    private static DeckOfCards deckOfCards;

    /**
     * Entrypoint
     */
    public static void main(String[] args) {
        port(PORT);
        Gson gson = new Gson();

        path("/deck", () -> {
            /**
             * Get the existing deck state
             */
            get("/", (req, res) -> {
                if (deckOfCards == null || deckOfCards.length() == 0) {
                    deckOfCards = new DeckOfCards();
                }

                res.type(JSON_RESPONSE);
                return gson.toJson(deckOfCards);
            });

            /**
             * Generate a new deck state, returning the new deck
             */
            get("/new", (req, res) -> {
                deckOfCards = new DeckOfCards();

                res.type(JSON_RESPONSE);
                return gson.toJson(deckOfCards);
            });

            /**
             * Get the existing deck state after shuffling
             */
            get("/shuffle", (req, res) -> {
                if (deckOfCards == null || deckOfCards.length() == 0) {
                    deckOfCards = new DeckOfCards();
                }

                deckOfCards.shuffle();

                res.type(JSON_RESPONSE);
                return gson.toJson(deckOfCards);
            });

            /**
             * Returns a described deck
             */
            get("/describe", (req, res) -> {
                if (deckOfCards == null || deckOfCards.length() == 0) {
                    deckOfCards = new DeckOfCards();
                }
                boolean isShortDescription = false;

                String type = req.queryParams("type");
                if (type.equals("short")) {
                    isShortDescription = true;
                }

                res.type(JSON_RESPONSE);
                return gson.toJson(deckOfCards.getDescribedDeck(isShortDescription));
            });

            /**
             * Returns the top card, removing it from the deck
             */
            get("/deal", (req, res) -> {
                if (deckOfCards == null || deckOfCards.length() == 0) {
                    deckOfCards = new DeckOfCards();
                }

                res.type(JSON_RESPONSE);
                return gson.toJson(deckOfCards.dealCardAtIndex(0));
            });
        });
    }
}
