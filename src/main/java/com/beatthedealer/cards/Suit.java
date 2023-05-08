package com.beatthedealer.cards;

import java.util.Arrays;

/**
 * Represents the suits of playing cards.
 */
public enum Suit {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private final String symbol;

    /**
     * Constructs a suit with the specified symbol.
     *
     * @param symbol the symbol representation of the suit
     */
    Suit(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol representation of the suit.
     *
     * @return the symbol representation of the suit
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns the suit associated with the specified symbol.
     *
     * @param symbol the symbol representation of the suit
     * @return the suit associated with the symbol
     * @throws IllegalArgumentException if the symbol is invalid
     */
    public static Suit fromSymbol(String symbol) {
        return Arrays.stream(Suit.values())
                .filter(suit -> suit.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid suit symbol: " + symbol));
    }

    /**
     * Returns the symbol representation of the suit.
     *
     * @return the symbol representation of the suit
     */
    @Override
    public String toString() {
        return symbol;
    }
}