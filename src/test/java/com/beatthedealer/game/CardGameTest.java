package com.beatthedealer.game;

import com.beatthedealer.cards.Rank;
import com.beatthedealer.cards.Suit;
import com.beatthedealer.deck.Deck;
import com.beatthedealer.player.Dealer;
import com.beatthedealer.player.Player;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class CardGameTest {

    @Test
    public void should_return_player_as_winner_when_player_has_blackjack() throws IOException {
        String deckContent = "CA, S2, D10, HJ";
        Path tempFile = Files.createTempFile("deck-of-cards", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck deck = new Deck(tempFile.toString());
        Player sam = new Player("Sam");
        Dealer dealer = new Dealer("Dealer");

        CardGame game = new CardGame(deck, sam, dealer);

        game.play();

        assertThat(game.getResult()).isEqualTo("Sam wins");
        assertThat(sam.getHand()).hasSize(2)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.CLUBS, Rank.ACE), Tuple.tuple(Suit.DIAMONDS, Rank.TEN));

        assertThat(dealer.getHand()).hasSize(2)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.SPADES, Rank.TWO), Tuple.tuple(Suit.HEARTS, Rank.JACK));
    }

    @Test
    public void should_return_player_as_winner_when_both_has_blackjack() throws IOException {
        String deckContent = "CA, SK, D10, HA";
        Path tempFile = Files.createTempFile("deck-of-cards", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck deck = new Deck(tempFile.toString());
        Player sam = new Player("Sam");
        Dealer dealer = new Dealer("Dealer");

        CardGame game = new CardGame(deck, sam, dealer);

        game.play();

        assertThat(game.getResult()).isEqualTo("Sam wins");
        assertThat(sam.getHand()).hasSize(2)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.CLUBS, Rank.ACE), Tuple.tuple(Suit.DIAMONDS, Rank.TEN));

        assertThat(dealer.getHand()).hasSize(2)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.SPADES, Rank.KING), Tuple.tuple(Suit.HEARTS, Rank.ACE));
    }

    @Test
    public void should_return_dealer_as_winner_when_player_is_busted() throws IOException {
        String deckContent = "CA, S10, D5, H10, S8";
        Path tempFile = Files.createTempFile("deck-of-cards", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck deck = new Deck(tempFile.toString());
        Player sam = new Player("Sam");
        Dealer dealer = new Dealer("Dealer");

        CardGame game = new CardGame(deck, sam, dealer);

        game.play();

        assertThat(game.getResult()).isEqualTo("Dealer wins");
        assertThat(sam.getHand()).hasSize(3)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.CLUBS, Rank.ACE), Tuple.tuple(Suit.DIAMONDS, Rank.FIVE), Tuple.tuple(Suit.SPADES, Rank.EIGHT));

        assertThat(dealer.getHand()).hasSize(2)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.SPADES, Rank.TEN), Tuple.tuple(Suit.HEARTS, Rank.TEN));
    }

    @Test
    public void should_return_player_as_winner_when_dealer_is_busted() throws IOException {
        String deckContent = "CA, S10, D5, H6, S3, S8";
        Path tempFile = Files.createTempFile("deck-of-cards", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck deck = new Deck(tempFile.toString());
        Player sam = new Player("Sam");
        Dealer dealer = new Dealer("Dealer");

        CardGame game = new CardGame(deck, sam, dealer);

        game.play();

        assertThat(game.getResult()).isEqualTo("Sam wins");
        assertThat(sam.getHand()).hasSize(3)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.CLUBS, Rank.ACE), Tuple.tuple(Suit.DIAMONDS, Rank.FIVE), Tuple.tuple(Suit.SPADES, Rank.THREE));

        assertThat(dealer.getHand()).hasSize(3)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.SPADES, Rank.TEN), Tuple.tuple(Suit.HEARTS, Rank.SIX), Tuple.tuple(Suit.SPADES, Rank.EIGHT));
    }

    @Test
    public void should_draw_player_until_the_score_is_greater_than_17() throws IOException {
        String deckContent = "CA, S10, D2, H6, S3, S5, S6";
        Path tempFile = Files.createTempFile("deck-of-cards", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck deck = new Deck(tempFile.toString());
        Player sam = new Player("Sam");
        Dealer dealer = new Dealer("Dealer");

        CardGame game = new CardGame(deck, sam, dealer);

        game.play();

        assertThat(game.getResult()).isEqualTo("Sam wins");
        assertThat(sam.getHand()).hasSize(4)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.CLUBS, Rank.ACE), Tuple.tuple(Suit.DIAMONDS, Rank.TWO), Tuple.tuple(Suit.SPADES, Rank.THREE),
                        Tuple.tuple(Suit.SPADES, Rank.FIVE));

        assertThat(dealer.getHand()).hasSize(3)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.SPADES, Rank.TEN), Tuple.tuple(Suit.HEARTS, Rank.SIX), Tuple.tuple(Suit.SPADES, Rank.SIX));
    }

    @Test
    public void should_draw_dealer_until_the_score_is_less_than_the_player() throws IOException {
        String deckContent = "CK, S2, D2, H6, S3, C2, D6, H4";
        Path tempFile = Files.createTempFile("deck-of-cards", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck deck = new Deck(tempFile.toString());
        Player sam = new Player("Sam");
        Dealer dealer = new Dealer("Dealer");

        CardGame game = new CardGame(deck, sam, dealer);

        game.play();

        assertThat(game.getResult()).isEqualTo("Dealer wins");
        assertThat(sam.getHand()).hasSize(4)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.CLUBS, Rank.KING), Tuple.tuple(Suit.DIAMONDS, Rank.TWO), Tuple.tuple(Suit.SPADES, Rank.THREE),
                        Tuple.tuple(Suit.CLUBS, Rank.TWO));

        assertThat(dealer.getHand()).hasSize(4)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.SPADES, Rank.TWO), Tuple.tuple(Suit.HEARTS, Rank.SIX), Tuple.tuple(Suit.DIAMONDS, Rank.SIX),
                        Tuple.tuple(Suit.HEARTS, Rank.FOUR));
    }


    @Test
    public void player_should_not_draw_more_than_the_initial_card_if_the_total_is_17_or_higher() throws IOException {
        String deckContent = "CA, S8, D7, H6, S3, C2, S2";
        Path tempFile = Files.createTempFile("deck-of-cards", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck deck = new Deck(tempFile.toString());
        Player sam = new Player("Sam");
        Dealer dealer = new Dealer("Dealer");

        CardGame game = new CardGame(deck, sam, dealer);

        game.play();

        assertThat(game.getResult()).isEqualTo("Dealer wins");
        assertThat(sam.getHand()).hasSize(2)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.CLUBS, Rank.ACE), Tuple.tuple(Suit.DIAMONDS, Rank.SEVEN));

        assertThat(dealer.getHand()).hasSize(4)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.SPADES, Rank.EIGHT), Tuple.tuple(Suit.HEARTS, Rank.SIX), Tuple.tuple(Suit.SPADES, Rank.THREE),
                        Tuple.tuple(Suit.CLUBS, Rank.TWO));
    }


    @Test
    public void dealer_should_win_if_both_started_with_bust() throws IOException {
        String deckContent = "CA, D2, HA, SA";
        Path tempFile = Files.createTempFile("deck-of-cards", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck deck = new Deck(tempFile.toString());
        Player sam = new Player("Sam");
        Dealer dealer = new Dealer("Dealer");

        CardGame game = new CardGame(deck, sam, dealer);

        game.play();

        assertThat(game.getResult()).isEqualTo("Dealer wins");
        assertThat(sam.getHand()).hasSize(2)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.CLUBS, Rank.ACE), Tuple.tuple(Suit.HEARTS, Rank.ACE));

        assertThat(dealer.getHand()).hasSize(2)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.DIAMONDS, Rank.TWO), Tuple.tuple(Suit.SPADES, Rank.ACE));
    }

    @Test
    public void player_should_win_if_dealer_started_with_bust() throws IOException {
        String deckContent = "C2, DA, HA, SA, D3";
        Path tempFile = Files.createTempFile("deck-of-cards", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck deck = new Deck(tempFile.toString());
        Player sam = new Player("Sam");
        Dealer dealer = new Dealer("Dealer");

        CardGame game = new CardGame(deck, sam, dealer);

        game.play();

        assertThat(game.getResult()).isEqualTo("Sam wins");
        assertThat(sam.getHand()).hasSize(3)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.CLUBS, Rank.TWO), Tuple.tuple(Suit.HEARTS, Rank.ACE), Tuple.tuple(Suit.DIAMONDS, Rank.THREE));

        assertThat(dealer.getHand()).hasSize(2)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.DIAMONDS, Rank.ACE), Tuple.tuple(Suit.SPADES, Rank.ACE));
    }

    @Test
    public void player_result_in_a_draw_if_both_have_equal_hands() throws IOException {
        String deckContent = "C2, DA, HA, S2";
        Path tempFile = Files.createTempFile("deck-of-cards", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck deck = new Deck(tempFile.toString());
        Player sam = new Player("Sam");
        Dealer dealer = new Dealer("Dealer");

        CardGame game = new CardGame(deck, sam, dealer);

        game.play();

        assertThat(game.getResult()).isEqualTo("It's a Draw!!!");
        assertThat(sam.getHand()).hasSize(2)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.CLUBS, Rank.TWO), Tuple.tuple(Suit.HEARTS, Rank.ACE));

        assertThat(dealer.getHand()).hasSize(2)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.DIAMONDS, Rank.ACE), Tuple.tuple(Suit.SPADES, Rank.TWO));
    }
}
               
