# Beat The Dealer

Can you beat the dealer at 21? This exercise is to model a card game with the following rules.

## Rules of the Game

1. The game is played with a single deck of playing cards.
2. There are only two players (in this case called Sam and the Dealer) who will play against each other. Initially
   each player is given 2 cards from the top of a deck of cards. Cards are given in the following order: sam,
   dealer, sam, dealer
3. Sam wins when both the player start with blackjack (a score of 21 with only two cards).
4. Dealer wins when both players start going bust with a value above 21: (A + A)
5. Sam can draw additional cards from the top of deck until his score reaches 17 or higher.
6. Sam will not draw more than their first two cards, if their initial hand is 17 or higher.
7. Sam has lost the game if their total reaches 22 or higher.
8. When sam has stopped drawing cards the dealer will start drawing cards from the top of the deck.
9. The dealer draws cards from the deck until their score is higher than Sam's.
10. The dealer has lost the game their total reaches 22 or higher
11. If neither Sam nor the dealer has a blackjack, and both players have final scores, the player with the higher score wins.


## Getting Started

To run the "Beat The Dealer" game, follow these steps:

1. Make sure you have Java 17 installed on your system.

2. Download or clone the project from the repository.

3. Compile the project by running the following command:
   ```
   mvn clean install
   ```
4. You can run the game using the following commands:
   ```
    mvn exec:java 
   ```
        
   or navigate the target/classes folder and then run

   ```
   java com.beatthedealer.BeatTheDealer
   
   ```
   This will start the game with a default deck.

5. (Optional) If you want to use a custom deck, provide the file path as a command line argument:
   ```
   mvn exec:java -Dexec.args="/path/to/custom_deck.txt"
   ```
   or navigate the target/classes folder and then run

    ```
   java com.beatthedealer.BeatTheDealer /path/to/custom_deck.txt
    ```
   
6. The custom deck file should contain a comma-separated list of card symbols. Each symbol consists of a suit symbol (C, D, H, S) followed by a rank symbol (2-10, J, Q, K, A).

## Sample Output

```
Sam wins
Sam's hand: [CA, H9]
Dealer's hand: [D5, HQ, S8]
```