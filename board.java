import java.util.Scanner;

public class Board {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman");
        System.out.println("You have five tries to guess the word");
        // Remove quotes around WordProvider.getWord()
        GameState game = new GameState(WordProvider.getWord(), 5);

        while (game.getAttemptsLeft() > 0) {
            System.out.println("Word so far: " + game.getfillerWord()); // Fixed method name casing
            System.out.print("Guess a letter: ");
            String guessedLetter = scanner.next().toLowerCase(); // Convert to lowercase for consistency

            boolean found = false;

            // Fixed substring logic
            for (int i = 0; i < game.hiddenWord.length(); i++) {
                if (game.hiddenWord.substring(i, i + 1).equals(guessedLetter)) {
                    found = true;
                }
            }

            if (found) {
                System.out.println("Good guess!");
                game.revealLetter(guessedLetter);
            } else {
                System.out.println("Nope, that letter isn't in the word.");
                game.decreaseAttempts();
                System.out.println("You have " + game.getAttemptsLeft() + " tries left.");
            }

            if (game.isWordGuessed()) {
                System.out.println("Yay! You guessed the word: " + game.hiddenWord);
                break;
            }
        }

        if (!game.isWordGuessed()) {
            System.out.println("You lost! The word was: " + game.hiddenWord);
        }

        scanner.close(); // Close the scanner when done
    }
}