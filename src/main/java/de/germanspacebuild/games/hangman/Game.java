package de.germanspacebuild.games.hangman;

import de.germanspacebuild.games.hangman.screen.MenuScreen;
import de.germanspacebuild.games.hangman.screen.ScreenUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Felix on 12.06.2017
 * for Hangman
 *
 * @author Felix
 */
public class Game {

    private int lives = 10;
    private Word word;
    private List<Character> usedChars = new ArrayList<>();
    private boolean running = true;

    public Game(Word word) {
        this.word = word;
    }

    public void init() {
        MenuScreen welcomeScreen = new MenuScreen(ScreenUtil.readTextFile("Title"));
        welcomeScreen.addText(ScreenUtil.readTextFile("Menu_Main"));
        welcomeScreen.addMenuAction(1, () -> loop());
        welcomeScreen.addMenuAction(2, () -> System.exit(0));
        welcomeScreen.print();
    }

    private void loop() {
        while (running) {
            ScreenUtil.clearScreen();
        }
    }

}
