import java.util.Random;
import java.util.Scanner;

class Game {
    private int computer;
    private int noOfGuesses;

    public Game() {
        Random rand = new Random();
        computer = rand.nextInt(100);
        System.out.println("Guess the Number from 1 to 100");
        noOfGuesses = 0;
    }

    public int getNoOfGuesses() {
        return noOfGuesses;
    }

    public void incrementNoOfGuesses() {
        noOfGuesses++;
    }

    public int computerNo() {
        return computer;
    }
}

public class numbergame {
    static int takeUserInput() {
        int user;
        System.out.println("Enter your guess:");
        Scanner sc = new Scanner(System.in);
        user = sc.nextInt();
        return user;
    }

    static void isCorrectNumber(int user, int computer) {
        if (user == computer) {
            System.out.println("Correct guess!");
        } else if (user > computer) {
            System.out.println("Your guess is higher than the computer's number.");
        } else {
            System.out.println("Your guess is lower than the computer's number.");
        }
    }

    public static void main(String[] args) {
        int user, computer, iterations = 0, maxAttempts = 8;
        boolean playAgain;

        do {
            Game game = new Game();

            do {
                user = takeUserInput();
                computer = game.computerNo();
                isCorrectNumber(user, computer);
                game.incrementNoOfGuesses();
                iterations++;

                if (user == computer || game.getNoOfGuesses() >= maxAttempts) {
                    break;
                }
            } while (true);

            System.out.println("Attempts taken: " + game.getNoOfGuesses());

            System.out.println("Do you want to play again? (1 for Yes, 0 for No): ");
            Scanner sc = new Scanner(System.in);
            playAgain = sc.nextInt() == 1;

        } while (playAgain);

        System.out.println("Thanks for playing!");
    }
}
