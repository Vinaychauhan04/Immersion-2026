//package bankapp2.Secret Number Puzzle Game;
package secretnumberpuzzlegame;

import java.util.Scanner;

class Game {

    private final int[][] cards = {
            {1, 3, 5, 7, 9, 11, 13, 15, 17, 19},
            {2, 3, 6, 7, 10, 11, 14, 15, 18, 19},
            {4, 5, 6, 7, 12, 13, 14, 15, 20},
            {8, 9, 10, 11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20}
    };

    private final int[] cardValues = {1, 2, 4, 8, 16};

    Scanner sc = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n===== Secret Number Puzzle Game =====");
            System.out.println("1. View Rules");
            System.out.println("2. Display Cards");
            System.out.println("3. Play Game");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        displayRules();
                        break;

                    case 2:
                        displayCards();
                        break;

                    case 3:
                        playGame();
                        break;

                    case 4:
                        System.out.println("Thank You for Playing!");
                        return;

                    default:
                        System.out.println("Invalid Choice! Try Again.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public void displayRules() {
        System.out.println("\n===== Game Rules =====");
        System.out.println("1. Think of a number between 1 and 20.");
        System.out.println("2. The program will show 5 cards.");
        System.out.println("3. For each card, answer Y if your number is present.");
        System.out.println("4. Answer N if your number is not present.");
        System.out.println("5. At the end, the program will guess your number.");
    }

    public void displayCards() {
        System.out.println("\n===== Secret Number Cards =====");

        for (int i = 0; i < cards.length; i++) {
            System.out.println("\nCard " + (i + 1) + ":");
            for (int num : cards[i]) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    public void playGame() {
        System.out.println("\nThink of a number between 1 and 20.");

        int secretNumber = 0;

        for (int i = 0; i < cards.length; i++) {

            System.out.println("\nCard " + (i + 1) + ":");
            for (int num : cards[i]) {
                System.out.print(num + "\t");
            }

            String answer;

            while (true) {
                System.out.print("\nIs your number present in this card? (Y/N): ");
                answer = sc.nextLine().trim().toUpperCase();

                if (answer.equals("Y") || answer.equals("N")
                        || answer.equals("YES") || answer.equals("NO")) {
                    break;
                }

                System.out.println("Invalid Input! Enter Y/N or Yes/No.");
            }

            if (answer.equals("Y") || answer.equals("YES")) {
                secretNumber += cardValues[i];
            }
        }

        System.out.println("\nYour Secret Number is: " + secretNumber);
    }
}

public class SecretNumberGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.showMenu();
    }
}
