package de.germanspacebuild.games.hangman.screen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Felix on 04.07.2017
 * for Hangman
 *
 * @author Felix
 */
public class Screen {

    protected String input = "";
    private String text;
    private Map<String, String> replaceTags = new HashMap<>();
    private boolean awaitsInput = false;

    public Screen(String text) {
        this.text = text;
    }

    public void print() {
        System.out.println(text);
        if (awaitsInput) {
            this.input = ScreenUtil.readInput();
        }
    }

    public String getText() {
        return text;
    }

    public void addText(String text) {
        StringBuilder sb = new StringBuilder(this.text);
        sb.append(text);
        this.text = sb.toString();
    }

    public void editRaplaceTag(String tag, String replacement) {
        replaceTags.put(tag, replacement);
    }

    public void addReplaceTag(String tag) {
        replaceTags.put(tag, "");
    }

    public Map<String, String> getReplaceTags() {
        return replaceTags;
    }

    public void setAwaitsInput(boolean awaitsInput) {
        this.awaitsInput = awaitsInput;
    }
}
