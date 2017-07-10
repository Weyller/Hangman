package de.germanspacebuild.games.hangman;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felix on 12.06.2017
 * for Hangman
 *
 * @author Felix
 */
public class Word {

    private String word;
    private String hiddenWord;
    private List<Character> validChars = new ArrayList<>();
    private List<Integer> letterIndicies = new ArrayList<>();

    public Word(String word) {
        this.word = word.toUpperCase();
        createHiddenWord();
        createValidCharList();
        createLetterList();
    }

    private void createHiddenWord() {
        hiddenWord = "";
        for (int i = 0; i < word.length(); i++) {
            hiddenWord = hiddenWord + "_ ";
        }
    }

    private void createValidCharList() {
        for (int i = 0; i < word.length(); i++) {
            if (!validChars.contains(word.charAt(i))) {
                validChars.add(word.charAt(i));
            }
        }
    }

    private void createLetterList() {
        int index = hiddenWord.indexOf("_");
        while (index >= 0) {
            letterIndicies.add(index);
            index = hiddenWord.indexOf("_", index + 1);
        }
    }

    public void uncoverLetter(char character) {
        char letter = Character.toUpperCase(character);
        StringBuilder sb = new StringBuilder(hiddenWord);
        int index = word.indexOf(letter);
        while (index != -1) {
            sb.setCharAt(letterIndicies.get(index), letter);
            word = word.replaceFirst(Character.toString(letter), "#");
            index = word.indexOf(letter);
        }
        hiddenWord = sb.toString();
    }

    public boolean isValidChar(char character) {
        return validChars.contains(Character.toUpperCase(character));
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

}
