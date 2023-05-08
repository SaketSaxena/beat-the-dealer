package com.beatthedealer.cards;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CardTest {

    @Test
    public void should_return_valid_card_for_valid_input() {
        Card card1 = Card.fromString("CA");
        assertThat(card1.getSuit()).isEqualTo(Suit.CLUBS);
        assertThat(card1.getRank()).isEqualTo(Rank.ACE);

        Card card2 = Card.fromString("D5");
        assertThat(card2.getSuit()).isEqualTo(Suit.DIAMONDS);
        assertThat(card2.getRank()).isEqualTo(Rank.FIVE);

        Card card3 = Card.fromString("H9");
        assertThat(card3.getSuit()).isEqualTo(Suit.HEARTS);
        assertThat(card3.getRank()).isEqualTo(Rank.NINE);

        Card card4 = Card.fromString("HQ");
        assertThat(card4.getSuit()).isEqualTo(Suit.HEARTS);
        assertThat(card4.getRank()).isEqualTo(Rank.QUEEN);
    }

    @Test
    public void should_throw_exception_for_invalid_input() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Card.fromString("CS"));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Card.fromString("DX34"));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Card.fromString("H13"));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Card.fromString("S"));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Card.fromString("KQ"));
    }
}