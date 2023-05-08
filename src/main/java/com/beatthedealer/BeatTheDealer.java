package com.beatthedealer;

import com.beatthedealer.deck.Deck;
import com.beatthedealer.game.CardGame;
import com.beatthedealer.player.Dealer;
import com.beatthedealer.player.Player;

/**
 * The main class for running the "Beat The Dealer" card game.
 * It initializes the deck, players, and game, and displays the result.
 */
public class BeatTheDealer {

    /**
     * The entry point of the "Beat The Dealer" card game.
     * It creates a deck based on the command line argument if provided, otherwise uses randomize shuffled deck
     * initializes the players, and runs the game.
     *
     * @param args The command line arguments. The first argument
     *             is the file path to a custom deck if provided. If no argument is provided,
     *             a default deck is used.
     */
    public static void main(String[] args) {
        Deck deck = null;
        if (args.length > 0) {
            String filePath = args[0];
            deck = new Deck(filePath);
        }

        if (deck == null || !deck.isNotEmpty()) {
            deck = new Deck();
        }

        Player sam = new Player("Sam");
        Dealer dealer = new Dealer("Dealer");

        CardGame game = new CardGame(deck, sam, dealer);
        game.play();

        System.out.println(game.getResult());
        System.out.printf("%s's hand: %s%n", sam.getName(), sam.getHand());
        System.out.printf("%s's hand: %s%n", dealer.getName(), dealer.getHand());
    }
}
