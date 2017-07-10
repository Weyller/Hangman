package de.germanspacebuild.games.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Felix on 12.06.2017
 * for Hangman
 *
 * @author Felix
 */
public class Hangman {

    private static List<Word> words = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        readWordList();
        Game game = new Game(words.get(new Random().nextInt(words.size())));
        game.init();
    }

    private static void readWordList() {
        InputStream in = ClassLoader.getSystemResourceAsStream("Words.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                words.add(new Word(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
