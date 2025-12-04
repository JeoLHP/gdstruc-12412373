import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner; 

public class Main {

    public static void main(String[] args) {

       
        Scanner scanner = new Scanner(System.in); 
        CardStack playerDeck = new CardStack();
        CardStack discardPile = new CardStack();

        List<Card> playerHand = new ArrayList<>();

        
        List<Card> cardsToShuffle = new ArrayList<>();

      
        for (Card.Suit suit : Card.Suit.values()) {
           
            for (Card.Rank rank : Card.Rank.values()) {
                cardsToShuffle.add(new Card(suit, rank));
            }
        }

       
        Collections.shuffle(cardsToShuffle);

       
        for (Card card : cardsToShuffle) {
            playerDeck.push(card);
        }

        System.out.println("Standard 52-card deck initialized and shuffled.");
        System.out.println("-------------------------------------------\n");

        // Start Game Loop
        int turn = 1;
        // The game ends when the player deck is empty
        while (!playerDeck.isEmpty()) {
            System.out.println("=== Turn " + (turn++) + " ===");

            // Display current stats
            System.out.println("Player Hand: " + playerHand);
            System.out.println("Cards in Deck: " + playerDeck.size());
            System.out.println("Cards in Discard: " + discardPile.size());
            System.out.println("\nChoose a command:");
            System.out.println("  1. Draw X cards");
            System.out.println("  2. Discard X cards");
            System.out.println("  3. Get X cards from discard");
            System.out.print("Enter command (1-3): ");

            int command = scanner.nextInt();
            int x; 

            switch (command) {
                case 1: 
                    System.out.print("How many cards to draw? ");
                    x = scanner.nextInt();
                    System.out.println("Command: Draw " + x + " cards.");
                    for (int i = 0; i < x; i++) {
                        if (playerDeck.isEmpty()) {
                            System.out.println("...but the deck is empty!");
                            break; 
                        }
                        Card drawnCard = playerDeck.pop();
                        playerHand.add(drawnCard);
                        System.out.println("Drew a: " + drawnCard);
                    }
                    break;

                case 2: 
                    System.out.print("Choose a number of cards to discard? ");
                    x = scanner.nextInt();
                    System.out.println("Command: Discard " + x + " cards.");
                    for (int i = 0; i < x; i++) {
                        if (playerHand.isEmpty()) {
                            System.out.println("your hand is empty!");
                            break; 
                        }

                        Card discardedCard = playerHand.remove(0);
                        discardPile.push(discardedCard);
                        System.out.println("Discarded a: " + discardedCard);
                    }
                    break;

                case 3: 
                    System.out.print("Choose a number of cards to get from the discard? ");
                    x = scanner.nextInt();
                    System.out.println("Command: Get " + x + " cards from discard.");
                    for (int i = 0; i < x; i++) {
                        if (discardPile.isEmpty()) {
                            System.out.println("discard pile is empty!");
                            break;
                        }
                        Card retrievedCard = discardPile.pop();
                        playerHand.add(retrievedCard);
                        System.out.println("Retrieved a: " + retrievedCard);
                    }
                    break;
                default:
                    System.out.println("Invalid, Skipped.");
                    break;
            }

            System.out.println("------------------------\n");
        }

      
        System.out.println("\n game is over, player deck is empty.");
        System.out.println("Final Hand: " + playerHand);
        System.out.println("Final Discard Pile: " + discardPile.size() + " cards.");

        scanner.close(); 
    }
}
