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

    private String rawWord;
    private String hiddenWord;
    private List<Character> validChars = new ArrayList<>();
    private List<Integer> letterIndicies = new ArrayList<>();

    public Word(String rawWord) {
        this.rawWord = rawWord.toUpperCase();
        createHiddenWord();
        createValidCharList();
        createLetterList();
    }

    private void createHiddenWord() {
        hiddenWord = "";
        for (int i = 0; i < rawWord.length(); i++) {
            hiddenWord = hiddenWord + "_ ";
        }
    }

    private void createValidCharList() {
        for (int i = 0; i < rawWord.length(); i++) {
            if (!validChars.contains(rawWord.charAt(i))) {
                validChars.add(rawWord.charAt(i));
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
        String word = rawWord;
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

    public String getRawWord() {
        return rawWord;
    }

    public boolean isUncovered() {
        return !hiddenWord.contains("_");
    }

}
