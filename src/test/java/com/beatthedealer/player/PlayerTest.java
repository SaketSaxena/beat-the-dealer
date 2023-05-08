package com.beatthedealer.player;

import com.beatthedealer.cards.Card;
import com.beatthedealer.cards.Rank;
import com.beatthedealer.cards.Suit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void should_return_correct_score_of_player_hand() {

        Player player = new Player("Sam");
        player.addCard(new Card(Suit.CLUBS, Rank.ACE));
        player.addCard(new Card(Suit.HEARTS, Rank.FOUR));
        player.addCard(new Card(Suit.HEARTS, Rank.TWO));

        assertThat(player.getScore()).isEqualTo(17);
    }

    @Test
    public void should_increase_player_score_after_adding_the_card() {
        Player player = new Player("Sam");

        player.addCard(new Card(Suit.CLUBS, Rank.FIVE));

        assertThat(player.getScore()).isEqualTo(5);
    }

    @Test
    public void should_return_true_if_player_hit_blackjack() {

        Player player = new Player("Sam");
        player.addCard(new Card(Suit.CLUBS, Rank.ACE));
        player.addCard(new Card(Suit.SPADES, Rank.TEN));

        assertThat(player.hasBlackjack()).isTrue();
    }

    @Test
    public void should_return_false_if_player_does_not_hit_blackjack() {

        Player player = new Player("Sam");
        player.addCard(new Card(Suit.CLUBS, Rank.ACE));
        player.addCard(new Card(Suit.SPADES, Rank.NINE));

        assertThat(player.hasBlackjack()).isFalse();
    }

    @Test
    public void should_return_true_if_player_is_busted() {

        Player player = new Player("Sam");
        player.addCard(new Card(Suit.CLUBS, Rank.QUEEN));
        player.addCard(new Card(Suit.HEARTS, Rank.KING));
        player.addCard(new Card(Suit.SPADES, Rank.JACK));

        assertThat(player.isBust()).isTrue();
    }

    @Test
    public void should_return_false_if_player_is_not_busted() {

        Player player = new Player("Sam");
        player.addCard(new Card(Suit.CLUBS, Rank.FIVE));
        player.addCard(new Card(Suit.HEARTS, Rank.ACE));

        assertThat(player.isBust()).isFalse();
    }

    @Test
    public void should_return_true_if_player_wants_to_draw() {

        Player player = new Player("Sam");
        player.addCard(new Card(Suit.CLUBS, Rank.FIVE));
        player.addCard(new Card(Suit.HEARTS, Rank.ACE));

        assertThat(player.wantsToDraw()).isTrue();
    }

    @Test
    public void should_return_false_if_player_is_does_not_want_to_draw() {

        Player player = new Player("Sam");
        player.addCard(new Card(Suit.CLUBS, Rank.QUEEN));
        player.addCard(new Card(Suit.HEARTS, Rank.KING));
        player.addCard(new Card(Suit.SPADES, Rank.JACK));

        assertThat(player.wantsToDraw()).isFalse();
    }
}
