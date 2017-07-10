package de.germanspacebuild.games.hangman.screen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Felix on 04.07.2017
 * for Hangman
 *
 * @author Felix
 */
public class ScreenUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static String readTextFile(String fileName) {
        String text = "";
        String line;

        if (!fileName.contains(".txt")) {
            StringBuilder sb = new StringBuilder(fileName);
            sb.append(".txt");
            fileName = sb.toString();
        }

        InputStream in = ClassLoader.getSystemResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        try {
            while ((line = reader.readLine()) != null) {
                StringBuilder sbText = new StringBuilder(text);
                sbText.append(line);
                sbText.append(System.lineSeparator());
                text = sbText.toString();
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
        return text;
    }

    public static void scanReplacementTags(Screen screen) {
        final String text = screen.getText();
        List<String> words = Arrays.asList(text.split("(\\r?\\n)"));
        for (String word : words) {
            if (word.startsWith("%")) {
                if (word.contains("File")) {
                    String[] file = word.split("([_])");
                    screen.addReplaceTag(word);
                    screen.editRaplaceTag(word, ScreenUtil.readTextFile(file[file.length - 1]));
                    continue;
                }
                screen.addReplaceTag(word);
            }
        }
    }

    public static String readInput() {
        String s = scanner.nextLine();
        if (s == null || s.isEmpty()) {
            s = "";
        }
        resetInput();
        return s;
    }

    private static void resetInput() {
        scanner = new Scanner(System.in);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }

}
