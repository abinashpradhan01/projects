// Building a game, to play stone paper and scissor
// Stone : 1
// Paper : 0
// Scissor : -1
// For win = 2 points

import java.util.Random;
import java.util.Scanner;

public class Stone_Paper_Scissor_Game {
    public static void main(String[] args) {
        Scanner sh = new Scanner(System.in);
        int you = 0;
        String compChoice = "";
        int cpoints = 0, ypoints = 0;

        System.out.println("STONE----PAPER----SCISSOR");

        for (int i = 0; i < 5; i++) {
            System.out.print("Choose your response (Stone, paper or Scissor): ");
            String choice = sh.next();

            if (choice.equalsIgnoreCase("stone")) {
                you = 1;
            } else if (choice.equalsIgnoreCase("paper")) {
                you = 0;
            } else if (choice.equalsIgnoreCase("scissor")) {
                you = -1;
            } else {
                System.out.println("Invalid input. Please choose Stone, Paper, or Scissor.");
                i--; // Repeat this round
                continue;
            }

            Random rand = new Random();
            int computer = rand.nextInt(3) - 1;

            if (computer == 1) {
                compChoice = "Stone";
            } else if (computer == 0) {
                compChoice = "Paper";
            } else {
                compChoice = "Scissor";
            }

            System.out.println("You chose: " + choice.toUpperCase());
            System.out.println("Computer chose: " + compChoice.toUpperCase());

            if (you == computer) {
                System.out.println("It's a draw.");
            } else if ((you == 1 && computer == -1) || (you == 0 && computer == 1) || (you == -1 && computer == 0)) {
                System.out.println("You WIN, Congratulations.");
                ypoints += 2;
            } else {
                System.out.println("You lose, try again...");
                cpoints += 2;
            }
        }

        System.out.print("Final Score: ");
        System.out.println("You: " + ypoints + " points");
        System.out.println("Computer: " + cpoints + " points");

        if (ypoints > cpoints) {
            System.out.printf("Voila! You WIN this game.\nCongratulations and Celebrations.");
        } else if (ypoints < cpoints) {
            System.out.printf("Sorry, you lost.\nIt's a matter of luck,\nI'm sure you will win next time.");
        } else {
            System.out.println("Unfortunately, it is a draw. Try hard next time.");
        }

        sh.close();
    }
}
