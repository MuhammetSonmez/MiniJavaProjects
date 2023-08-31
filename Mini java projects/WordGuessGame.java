import java.util.Random;
import java.util.Scanner;

public class WordGuessGame {

    public void run() {
        String[] words = {"hello", "world", "python", "java", "bootstrap", "html", "css", "javascript"};
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String selectedWord = words[randomIndex];
        int maxAttempts = 5;
        int remainingAttempts = maxAttempts;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("The length of the word you need to guess: " + selectedWord.length());
        
        StringBuilder guessedWord = new StringBuilder("-".repeat(selectedWord.length()));
        
        while (remainingAttempts > 0) {
            System.out.println("Enter the guessed letter or word:");
            String input = scanner.nextLine().toLowerCase();
            
            if (input.equals(selectedWord)) {
                System.out.println("Congratulations, you guessed it right! Word: " + selectedWord);
                break;
            } else if (input.length() == 1) {
                char guessedChar = input.charAt(0);
                boolean found = false;
                for (int i = 0; i < selectedWord.length(); i++) {
                    if (selectedWord.charAt(i) == guessedChar) {
                        guessedWord.setCharAt(i, guessedChar);
                        found = true;
                    }
                }
                if (!found) {
                    remainingAttempts--;
                    System.out.println("Wrong guess. Remaining attempts: " + remainingAttempts);
                }
                
                System.out.println("Guess Status: " + guessedWord);
                
                if (guessedWord.toString().equals(selectedWord)) {
                    System.out.println("Congratulations, you guessed it right! Word: " + selectedWord);
                    break;
                }
            } else {
                System.out.println("Invalid guess. Please enter only a single letter or word.");
            }
        }
        
        if (remainingAttempts == 0) {
            System.out.println("Sorry, you're out of attempts. Correct word: " + selectedWord);
        }
        
        scanner.close();
    }
}
