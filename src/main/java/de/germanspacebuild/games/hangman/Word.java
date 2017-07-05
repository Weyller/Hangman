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

    public Word(String word) {
        this.word = word.toUpperCase();
        createHiddenWord();
        createValidCharList();
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

    public void uncoverLetter(char character) {
        int index = word.indexOf(character);
        StringBuilder sb = new StringBuilder(hiddenWord);
        while (index != -1) {
            sb.setCharAt(index, Character.toUpperCase(character));
        }
    }

    public boolean isValidChar(char character) {
        return validChars.contains(Character.valueOf(character));
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

}
