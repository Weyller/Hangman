package de.germanspacebuild.games.hangman;

import de.germanspacebuild.games.hangman.screen.MenuScreen;
import de.germanspacebuild.games.hangman.screen.Screen;
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
        MenuScreen welcomeScreen = new MenuScreen(ScreenUtil.readTextFile("Menu_Main"));
        ScreenUtil.scanReplacementTags(welcomeScreen);
        welcomeScreen.addMenuAction(1, () -> loop());
        welcomeScreen.addMenuAction(2, () -> System.exit(0));
        welcomeScreen.print();
    }

    private void loop() {
        Screen gameScreen = new Screen(ScreenUtil.readTextFile("Game"));
        ScreenUtil.scanReplacementTags(gameScreen);
        while (running) {
            ScreenUtil.clearScreen();
            gameScreen.print();
        }
    }

}
