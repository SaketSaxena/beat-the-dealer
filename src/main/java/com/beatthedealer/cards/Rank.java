package com.beatthedealer.cards;

import java.util.Arrays;

/**
 * Represents the ranks of playing cards.
 */
public enum Rank {
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10),
    ACE("A", 11);

    private final String symbol;
    private final int value;

    /**
     * Constructs a rank with the specified symbol and value.
     *
     * @param symbol the symbol representation of the rank
     * @param value  the value associated with the rank
     */
    Rank(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    /**
     * Returns the value associated with the rank.
     *
     * @return the value associated with the rank
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the rank associated with the specified symbol.
     *
     * @param symbol the symbol representation of the rank
     * @return the rank associated with the symbol
     * @throws IllegalArgumentException if the symbol is invalid
     */
    public static Rank fromSymbol(String symbol) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid rank symbol: " + symbol));
    }

    /**
     * Returns the symbol representation of the rank.
     *
     * @return the symbol representation of the rank
     */
    @Override
    public String toString() {
        return symbol;
    }
}