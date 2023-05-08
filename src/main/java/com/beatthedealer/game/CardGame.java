package com.beatthedealer.game;

import com.beatthedealer.deck.Deck;
import com.beatthedealer.player.Dealer;
import com.beatthedealer.player.Player;

/**
 * Represents a card game between a player and a dealer.
 */
public class CardGame {
    private final Deck deck;
    private final Player player;
    private final Dealer dealer;
    private GameResult result;

    /**
     * Constructs a new CardGame object with the specified deck, player, and dealer.
     *
     * @param deck   the deck of cards to be used in the game
     * @param player the player in the game
     * @param dealer the dealer in the game
     */
    public CardGame(Deck deck, Player player, Dealer dealer) {
        this.deck = deck;
        this.player = player;
        this.dealer = dealer;
    }

    /**
     * Plays the card game.
     * Deals initial cards, checks for blackjack or bust, allows the player and dealer to draw further cards,
     * and calculates the final result of the game.
     */
    public void play() {
        dealInitialCards();

        if (player.hasBlackjack()) {
            result = GameResult.PLAYER_WINS;
            return;
        } else if (dealer.hasBlackjack() || player.isBust()) {
            result = GameResult.DEALER_WINS;
            return;
        }

        if (drawPlayer()) return;

        if (drawDealer()) return;

        calculateScore();
    }

    /**
     * Gets the result of the card game.
     *
     * @return the result of the game as a formatted string
     */
    public String getResult() {
        if (result.equals(GameResult.PLAYER_WINS)) {
            return String.format("%s wins", player.getName());
        } else if (result.equals(GameResult.DEALER_WINS)) {
            return String.format("%s wins", dealer.getName());
        } else {
            return "It's a Draw!!!";
        }
    }

    private void dealInitialCards() {
        player.addCard(deck.takeCard());
        dealer.addCard(deck.takeCard());
        player.addCard(deck.takeCard());
        dealer.addCard(deck.takeCard());
    }

    private boolean drawPlayer() {
        while (deck.isNotEmpty() && player.wantsToDraw()) {
            player.addCard(deck.takeCard());
            if (player.isBust()) {
                result = GameResult.DEALER_WINS;
                return true;
            }
        }
        return false;
    }

    private boolean drawDealer() {
        while (deck.isNotEmpty() && dealer.wantsToDraw(player.getScore())) {
            dealer.addCard(deck.takeCard());
            if (dealer.isBust()) {
                result = GameResult.PLAYER_WINS;
                return true;
            }
        }
        return false;
    }

    private void calculateScore() {
        int samScore = player.getScore();
        int dealerScore = dealer.getScore();
        if (dealer.isBust() || samScore > dealerScore) {
            result = GameResult.PLAYER_WINS;
        } else if (samScore < dealerScore) {
            result = GameResult.DEALER_WINS;
        } else {
            result = GameResult.DRAW;
        }
    }
}
