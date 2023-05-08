package com.beatthedealer.cards;

import org.junit.jupiter.api.Test;

import static com.beatthedealer.cards.Suit.CLUBS;
import static org.assertj.core.api.Assertions.*;

public class SuitTest {

    @Test
    public void should_return_correct_symbol_for_club_card() {
        assertThat(CLUBS.getSymbol()).isEqualTo("C");
    }

    @Test
    public void should_return_correct_symbol_for_diamond_card() {
        assertThat(Suit.DIAMONDS.getSymbol()).isEqualTo("D");
    }

    @Test
    public void should_return_correct_symbol_for_hearts_card() {
        assertThat(Suit.HEARTS.getSymbol()).isEqualTo("H");
    }

    @Test
    public void should_return_correct_symbol_for_spades_card() {
        assertThat(Suit.SPADES.getSymbol()).isEqualTo("S");
    }

    @Test
    public void should_return_correct_suit_for_symbol_C() {
        assertThat(Suit.fromSymbol("C")).isEqualTo(CLUBS);
    }

    @Test
    public void should_return_correct_suit_for_symbol_D() {
        assertThat(Suit.fromSymbol("D")).isEqualTo(Suit.DIAMONDS);
    }

    @Test
    public void should_return_correct_suit_for_symbol_H() {
        assertThat(Suit.fromSymbol("H")).isEqualTo(Suit.HEARTS);
    }

    @Test
    public void should_return_correct_suit_for_symbol_S() {
        assertThat(Suit.fromSymbol("S")).isEqualTo(Suit.SPADES);
    }
}
