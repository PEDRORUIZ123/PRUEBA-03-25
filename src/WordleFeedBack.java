/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruizc
 */
public class WordleFeedBack {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_WHITE = "\u001B[37m";

// Método auxiliar para aplicar color
    private static String applyColor(String letter, String color) {
        return color + letter + ANSI_RESET;
    }

    public static String feedBackString(String guess, String secretWord) {
        StringBuilder feedback = new StringBuilder();
        int length = guess.length();
        int[] letterCounts = new int[26]; // Para contar letras en secretWord

        // Contamos las apariciones de cada letra en secretWord
        for (char c : secretWord.toCharArray()) {
            letterCounts[c - 'a']++;
        }

        char[] result = new char[length];

        // Paso 1: Marcar letras en posición correcta (verde)
        for (int i = 0; i < length; i++) {
            if (guess.charAt(i) == secretWord.charAt(i)) {
                result[i] = 'G'; // Verde
                letterCounts[guess.charAt(i) - 'a']--;
            }
        }

        // Paso 2: Marcar letras en posición incorrecta (amarillo) solo si quedan disponibles
        for (int i = 0; i < length; i++) {
            char letter = guess.charAt(i);
            if (result[i] != 'G') { // Si no es verde
                if (letterCounts[letter - 'a'] > 0) {
                    result[i] = 'Y'; // Amarillo
                    letterCounts[letter - 'a']--;
                } else {
                    result[i] = 'W'; // Blanco
                }
            }
        }

        // Construir la respuesta con colores
        for (int i = 0; i < length; i++) {
            char letter = guess.charAt(i);
            if (result[i] == 'G') {
                feedback.append(applyColor(String.valueOf(letter), ANSI_GREEN));
            } else if (result[i] == 'Y') {
                feedback.append(applyColor(String.valueOf(letter), ANSI_YELLOW));
            } else {
                feedback.append(applyColor(String.valueOf(letter), ANSI_WHITE));
            }
        }

        return feedback.toString();
    }
}
