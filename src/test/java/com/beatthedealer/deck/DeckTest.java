package com.beatthedealer.deck;

import com.beatthedealer.cards.Card;
import com.beatthedealer.cards.Rank;
import com.beatthedealer.cards.Suit;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {

    @Test
    public void should_read_deck_from_a_file() throws IOException {
        String deckContent = "CA, D5, H9, HQ, S8";
        Path tempFile = Files.createTempFile("deck-of-cards", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck actualDeck = new Deck(tempFile.toString());

        assertThat(actualDeck.getCards())
                .isNotEmpty()
                .hasSize(5)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.CLUBS, Rank.ACE), Tuple.tuple(Suit.DIAMONDS, Rank.FIVE), Tuple.tuple(Suit.HEARTS, Rank.NINE),
                        Tuple.tuple(Suit.HEARTS, Rank.QUEEN), Tuple.tuple(Suit.SPADES, Rank.EIGHT));

        Files.delete(tempFile);
    }

    @Test
    public void should_generate_empty_deck_if_the_file_is_empty() throws IOException {
        Path tempFile = Files.createTempFile("deck", ".txt");

        Deck actualDeck = new Deck(tempFile.toString());

        assertThat(actualDeck.isNotEmpty()).isFalse();

        Files.delete(tempFile);
    }

    @Test
    public void should_generate_empty_deck_if_file_does_not_exists() {
        String filePath = "non_existing_file.txt";

        Deck actualDeck = new Deck(filePath);

        assertThat(actualDeck.isNotEmpty()).isFalse();
    }

    @Test
    public void should_generate_new_shuffled_deck() {
        Deck actualDeck = new Deck();

        assertThat(actualDeck.getCards()).isNotEmpty();
        assertThat(actualDeck.getCards()).hasSize(52);
    }

    @Test
    public void should_take_card_from_top_of_deck() throws IOException {
        String deckContent = "CA, D5, H9, HQ, S8";
        Path tempFile = Files.createTempFile("deck", ".txt");
        Files.write(tempFile, deckContent.getBytes());

        Deck actualDeck = new Deck(tempFile.toString());

        Card withdrawCard = actualDeck.takeCard();

        assertThat(withdrawCard).extracting("suit", "rank")
                        .contains(Suit.CLUBS, Rank.ACE);

        assertThat(actualDeck.getCards())
                .isNotEmpty()
                .hasSize(4)
                .extracting("suit", "rank")
                .contains(Tuple.tuple(Suit.DIAMONDS, Rank.FIVE), Tuple.tuple(Suit.HEARTS, Rank.NINE),
                        Tuple.tuple(Suit.HEARTS, Rank.QUEEN), Tuple.tuple(Suit.SPADES, Rank.EIGHT));

        Files.delete(tempFile);
    }
}
