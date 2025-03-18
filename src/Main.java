
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ruizc
 */
public class Main {

    public static void main(String[] args) {
        String [] fileWords;
        fileWords = WordleFileManager.loadWords("C:\\Users\\ruizc\\Documents\\palabras.txt");
        if (fileWords.length == 0) {
            System.out.println("No se pudieron cargar palabras. Verifica el archivo.");
        }
        
        WordleGame game = new WordleGame(fileWords);
        game.start();
        
//        System.out.println(WordleFeedBack.feedBackString("perro", "paron"));
    System.exit(1);

    }
}
