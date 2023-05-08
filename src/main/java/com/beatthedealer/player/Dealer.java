package com.beatthedealer.player;

/**
 * Represents a dealer in the card game.
 * Inherits from the Player class.
 */
public class Dealer extends Player {

    /**
     * Constructs a new Dealer object with the given name.
     *
     * @param name the name of the dealer
     */
    public Dealer(String name) {
        super(name);
    }

    /**
     * Determines if the dealer wants to draw another card based on the total score of the player.
     * The dealer wants to draw until their current score higher than the player's total score.
     *
     * @param playerTotal the total score of the player
     * @return true if the dealer wants to draw, false otherwise
     */
    public boolean wantsToDraw(int playerTotal) {
        return getScore() < playerTotal;
    }
}