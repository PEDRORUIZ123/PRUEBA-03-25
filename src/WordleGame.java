/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;
/**
 *
 * @author ruizc
 */
public class WordleGame {
 private static final int MAX_ATTEMPTS = 6;
    private static final int WORD_LENGTH = 5;
    private String[] wordList;
    private String targetWord;
    private int attemptsLeft;
    private List<String> attemptsHistory;

    public WordleGame(String[] wordList) {
        this.wordList = wordList;
        this.targetWord = selectRandomWord();
        this.attemptsLeft = MAX_ATTEMPTS;
        this.attemptsHistory = new ArrayList<>();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (attemptsLeft > 0) {
            System.out.println("\nHas intentado las palabras:");
            showAttemptsHistory();
            System.out.println("Tienes " + attemptsLeft + " intentos restantes.");
            System.out.print("Introduce una palabra de " + WORD_LENGTH + " letras: ");
            String guess = getUserInput(scanner);
            attemptsHistory.add(guess);
            if (guess.equals(targetWord)) {
                System.out.println("Felicidades! Has adivinado la palabra: " + targetWord);
                break;
            }
            
            System.out.println(WordleFeedBack.feedBackString(guess, targetWord));
            attemptsLeft--;
        }
        if (!targetWord.equals(attemptsHistory.get(attemptsHistory.size() - 1))) {
            System.out.println("La palabra correcta era: " + targetWord);
        }
        WordleFileManager.saveGameHistory(attemptsHistory);
    }

    private void showAttemptsHistory() {
        for (String attempt : attemptsHistory) {
            System.out.println(attempt);
        }
    }

    private String selectRandomWord() {
        Random random = new Random();
        return wordList[random.nextInt(wordList.length)];
    }

    private String getUserInput(Scanner scanner) {
        String input;
        do {
            input = scanner.nextLine().toLowerCase();
            if (input.length() != WORD_LENGTH) {
                System.out.println("La palabra debe tener " + WORD_LENGTH + " letras. Por favor intentelo de nuevo");
            }
        } while (input.length() != WORD_LENGTH);
        return input;
    }
}
