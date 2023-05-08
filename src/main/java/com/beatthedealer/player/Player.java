package com.beatthedealer.player;

import com.beatthedealer.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player in the card game.
 */
public class Player {
    private final String name;
    private final List<Card> hand;

    /**
     * Constructs a new Player object with the given name.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    /**
     * Gets the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a card to the player's hand.
     *
     * @param card the card to be added
     */
    public void addCard(Card card) {
        hand.add(card);
    }

    /**
     * Calculates the score of the player's hand.
     *
     * @return the score of the player's hand
     */
    public int getScore() {
        return hand.stream()
                .mapToInt(card -> card.getRank().getValue())
                .sum();
    }

    /**
     * Checks if the player has a blackjack (hand of two cards with a total score of 21).
     *
     * @return true if the player has a blackjack, false otherwise
     */
    public boolean hasBlackjack() {
        return hand.size() == 2 && getScore() == 21;
    }

    /**
     * Checks if the player's hand is bust (score greater than 21).
     *
     * @return true if the player's hand is bust, false otherwise
     */
    public boolean isBust() {
        return getScore() > 21;
    }

    /**
     * Gets the player's hand.
     *
     * @return a list of cards in the player's hand
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * Determines if the player wants to draw another card.
     * The player wants to draw until their current score is 17 or higher.
     *
     * @return true if the player wants to draw, false otherwise
     */
    public boolean wantsToDraw() {
        return getScore() < 17;
    }
}