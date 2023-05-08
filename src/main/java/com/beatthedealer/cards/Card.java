package com.beatthedealer.cards;

/**
 * Represents a playing card.
 */
public final class Card {
    private final Suit suit;
    private final Rank rank;

    /**
     * Constructs a card with the specified suit and rank.
     *
     * @param suit the suit of the card
     * @param rank the rank of the card
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Creates a card from the specified string representation.
     *
     * @param cardString the string representation of the card
     * @return the card created from the string representation
     * @throws IllegalArgumentException if the card string is invalid
     */
    public static Card fromString(String cardString) {
        if (cardString.length() < 2 || cardString.length() > 3) {
            throw new IllegalArgumentException("Invalid card symbol: " + cardString);
        }

        String suitChar = String.valueOf(cardString.charAt(0));
        String rankString = cardString.substring(1);

        Suit suit = Suit.fromSymbol(suitChar);
        Rank rank = Rank.fromSymbol(rankString);

        return new Card(suit, rank);
    }

    /**
     * Returns the string representation of the card.
     *
     * @return the string representation of the card
     */
    @Override
    public String toString() {
        return suit.toString() + rank.toString();
    }

    /**
     * Returns the suit of the card.
     *
     * @return the suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns the rank of the card.
     *
     * @return the rank of the card
     */
    public Rank getRank() {
        return rank;
    }
}