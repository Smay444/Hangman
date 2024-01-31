import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // create an array of misc words
        String[] wordList = {"Passion", "Determination", "happiness", "love", "hangman", "willingness", "creativity"};

        // select a random word
        String secretWord = wordList[random.nextInt(wordList.length)];

        //you have to separate the letters of the word
        char[] secretWordArray = secretWord.toCharArray();
        char[] displayedWord = new char[secretWord.length()];

        for (int i = 0; i < secretWord.length(); i++) {
            displayedWord[i] = '_';
        }

        int attemptsLeft = 10;
        boolean wordGuessed = false;  // Flag to track if the word has been guessed

        while (attemptsLeft > 0 && !wordGuessed) {
            System.out.println("Current Word: " + String.valueOf(displayedWord));
            System.out.println("Attempts Left: " + attemptsLeft);

            System.out.println("Guess a letter: ");
            char guess = scanner.next().charAt(0);

            boolean correctGuess = false;

            for (int i = 0; i < secretWord.length(); i++) {
                if (Character.toLowerCase(secretWordArray[i]) == Character.toLowerCase(guess)) {
                    displayedWord[i] = guess;
                    correctGuess = true;
                }
            }
            if (!correctGuess) {
                attemptsLeft--;
                System.out.println("Incorrect Guess. Try Again");
            }
            if (String.valueOf(displayedWord).equals(secretWord)) {
                System.out.println("Yay. You guessed the word");
                wordGuessed = true;  // Set the flag to true
            }
            if (attemptsLeft == 0) {
                System.out.println("Sorry, you ran out of turns");
            }
        }

        // Close the scanner
        scanner.close();
    }
}