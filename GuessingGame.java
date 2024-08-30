import java.util.Scanner;

class Game {
    Scanner s = new Scanner(System.in);
    int choice, nguess = 0;
    boolean result = false;
    int comp = (int) (Math.random() * 100) + 1;

    void startgame() {
        System.out.print("Give your guess (should be between 1 and 100): ");
        choice = s.nextInt();

        if (!(choice > 0 && choice < 100)) {
            System.out.println("Invalid input. Exiting...");
            System.exit(0);
        } else {
            nguess += 1;
        }

        if (choice == comp) {
            result = true;
        } else if (choice > comp) {
            System.out.println("Lesser guess please.");
            startgame();
        } else {
            System.out.println("Higher guess please.");
            startgame();
        }
    }
}

public class Guessing_Game {
    public static void main(String[] args) {
        System.out.println("**--** Guessing Game **--**");
        Game g = new Game();
        g.startgame();

        if (g.result) {
            System.out.println();
            System.out.printf("You guessed it right and number of guesses is: %d\n", g.nguess);
            System.out.printf("You chose: %d\nComputer chose: %d\n", g.choice, g.comp);
        }
    }
}
