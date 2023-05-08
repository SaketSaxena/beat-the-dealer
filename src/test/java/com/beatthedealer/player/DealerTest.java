package com.beatthedealer.player;

import com.beatthedealer.cards.Card;
import com.beatthedealer.cards.Rank;
import com.beatthedealer.cards.Suit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    @Test
    public void should_return_true_if_dealer_wants_to_draw() {

        Dealer dealer = new Dealer("Dealer");
        dealer.addCard(new Card(Suit.CLUBS, Rank.TWO));
        dealer.addCard(new Card(Suit.HEARTS, Rank.ACE));

        assertThat(dealer.wantsToDraw(15)).isTrue();
    }

    @Test
    public void should_return_false_if_dealer_is_does_not_want_to_draw() {

        Dealer dealer = new Dealer("Dealer");
        dealer.addCard(new Card(Suit.CLUBS, Rank.QUEEN));
        dealer.addCard(new Card(Suit.HEARTS, Rank.SEVEN));

        assertThat(dealer.wantsToDraw(15)).isFalse();
    }
}
