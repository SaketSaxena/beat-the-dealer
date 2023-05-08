package com.beatthedealer.cards;

import org.junit.jupiter.api.Test;

import static com.beatthedealer.cards.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void should_return_correct_value_for_number_card() {
        assertThat(FIVE.getValue()).isEqualTo(5);
    }

    @Test
    public void should_return_correct_value_for_jack_card() {
        assertThat(JACK.getValue()).isEqualTo(10);
    }

    @Test
    public void should_return_correct_value_for_queen_Card() {
        assertThat(QUEEN.getValue()).isEqualTo(10);
    }

    @Test
    public void should_return_correct_value_for_king_card() {
        assertThat(KING.getValue()).isEqualTo(10);
    }

    @Test
    public void should_return_correct_value_for_ace_card() {
        assertThat(ACE.getValue()).isEqualTo(11);
    }

    @Test
    public void should_return_correct_rank_for_value_A() {
        assertThat(fromSymbol("A")).isEqualTo(ACE);
    }

    @Test
    public void should_return_correct_rank_for_value_KING() {
        assertThat(fromSymbol("K")).isEqualTo(KING);
    }

    @Test
    public void should_return_correct_rank_for_value_5() {
        assertThat(fromSymbol("5")).isEqualTo(FIVE);
    }
}