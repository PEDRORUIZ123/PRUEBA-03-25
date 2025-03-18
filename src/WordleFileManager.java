
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruizc
 */
public class WordleFileManager {

       public static String [] loadWords(String path) {
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        String [] fileWords = words.toArray(String[]::new);
        return fileWords;
    }
    
    public static void saveHistory(List<String> history) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\ruizc\\Documents\\game_history.txt", true))) {
            for (String attempt : history) {
                writer.write(attempt + "\n");
            }
            writer.write("""
                         ==== Fin de partida ====
                         """);
        } catch (IOException e) {
            System.out.println("Error al guardar el historial de la partida.");
        }
    }

    static void saveGameHistory(List<String> triesHistory) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
