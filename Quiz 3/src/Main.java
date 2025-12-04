import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        LinkedStack stack = new LinkedStack();

        int gamesCreated = 0;
        int turn = 1;
        int playerIdCounter = 1;

        while (gamesCreated < 10) {
            System.out.println("--- Turn " + (turn++) + " (Games created: " + gamesCreated + "/10) ---");
            System.out.println("Press Enter to simulate new players joining...");
            scanner.nextLine();


            int playersToAdd = random.nextInt(7) + 1;
            System.out.println(playersToAdd + " players joined the matchmaking.");

            for (int i = 0; i < playersToAdd; i++) {
                Player newPlayer = new Player(playerIdCounter, "Player" + playerIdCounter, random.nextInt(100) + 1);
                stack.push(newPlayer);
                System.out.println("  - " + newPlayer.getUserName() + " (Level " + newPlayer.getLevel() + ") entered matchmaking.");
                playerIdCounter++;
            }

            System.out.println("\nCurrent stack size: " + stack.size());
            stack.printStack();


            if (stack.size() >= 5) {
                gamesCreated++;
                System.out.println("\n--- GAME " + gamesCreated + " STARTING! ---");
                System.out.println("Removing 5 players from stack:");


                for (int i = 0; i < 5; i++) {
                    Player playerInGame = stack.pop();
                    System.out.println("  - " + playerInGame.getUserName() + " has joined the game.");
                }

                System.out.println("--- GAME " + gamesCreated + " IN PROGRESS ---\n");
            } else {
                System.out.println("\nNot enough players to start a game. Waiting for more...\n");
            }

            System.out.println("---------------------------------");
        }

        System.out.println("\n10 games have been successfully created. Program terminating.");
        scanner.close();
    }
}
//
