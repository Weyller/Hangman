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
    private final String text;
    private Map<String, String> replaceTags = new HashMap<>();
    private boolean awaitsInput = false;

    public Screen(String text) {
        this.text = text;
    }

    public void print() {
        String screen = text;
        for (String key : replaceTags.keySet()) {
            screen = screen.replaceAll(key, replaceTags.get(key));
        }
        System.out.println(screen);
        if (awaitsInput) {
            this.input = ScreenUtil.readInput();
        }
    }

    public void close() {
        replaceTags.clear();
        input = "";
    }

    public String getText() {
        return text;
    }

    public void editRaplaceTag(String tag, String replacement) {
        replaceTags.put(tag, replacement);
    }

    public void addReplaceTag(String tag) {
        replaceTags.put(tag, "@WARNING_NO_REPLACEMENT@ " + tag);
    }

    public Map<String, String> getReplaceTags() {
        return replaceTags;
    }

    public String getInput() {
        return input;
    }

    public void setAwaitsInput(boolean awaitsInput) {
        this.awaitsInput = awaitsInput;
    }
}
