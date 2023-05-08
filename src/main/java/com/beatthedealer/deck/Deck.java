package com.beatthedealer.deck;

import com.beatthedealer.cards.Card;
import com.beatthedealer.cards.Rank;
import com.beatthedealer.cards.Suit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents a deck of playing cards.
 */
public class Deck {
    private List<Card> cards = new ArrayList<>();

    /**
     * Constructs a new deck of cards. The deck is generated and shuffled.
     */
    public Deck() {
        cards = generateDeck();
        shuffle();
    }

    /**
     * Constructs a new deck of cards from the specified file. The file should contain one or more lines
     * with comma-separated card symbols. The deck is generated based on the cards in the file.
     *
     * @param filePath the path to the file containing the card symbols
     */
    public Deck(String filePath) {
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            lines.flatMap(line -> Arrays.stream(line.split(",")))
                    .map(String::trim)
                    .map(Card::fromString)
                    .forEach(cards::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Card> generateDeck() {
        return Arrays.stream(Suit.values())
                .flatMap(suit -> Arrays.stream(Rank.values())
                        .map(rank -> new Card(suit, rank)))
                .collect(Collectors.toList());
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Takes a card from the top of the deck.
     *
     * @return the card taken from the deck
     */
    public Card takeCard() {
        return cards.remove(0);
    }

    /**
     * Checks if the deck is not empty.
     *
     * @return true if the deck is not empty, false otherwise
     */
    public boolean isNotEmpty() {
        return !cards.isEmpty();
    }

    /**
     * Returns the list of cards in the deck.
     *
     * @return the list of cards in the deck
     */
    public List<Card> getCards() {
        return cards;
    }
}