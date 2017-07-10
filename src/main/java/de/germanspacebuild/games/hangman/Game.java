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
    private String livesText = "";
    private Screen gameScreen;

    public Game(Word word) {
        this.word = word;
    }

    public void init() {
        ScreenUtil.clearScreen();
        MenuScreen welcomeScreen = new MenuScreen(ScreenUtil.readTextFile("Menu_Main"));
        ScreenUtil.scanReplacementTags(welcomeScreen);
        welcomeScreen.addMenuAction(1, this::loop);
        welcomeScreen.addMenuAction(2, () -> System.exit(0));
        welcomeScreen.print();
        welcomeScreen.close();
    }

    private void loop() {
        gameScreen = new Screen(ScreenUtil.readTextFile("Game"));
        ScreenUtil.scanReplacementTags(gameScreen);
        gameScreen.setAwaitsInput(true);
        while (running) {
            ScreenUtil.clearScreen();
            updateDisplay();
            gameScreen.print();
            handleInput();
        }
    }

    private void handleInput() {
        String input = gameScreen.getInput();
        if (input.isEmpty() || input == "") {
            return;
        }
        char guessChar = input.charAt(0);
        if (word.isValidChar(guessChar)) {
            word.uncoverLetter(guessChar);
        } else {
            lives--;
            if (!usedChars.contains(guessChar)) {
                usedChars.add(Character.toUpperCase(guessChar));
            }
        }
    }

    private void updateDisplay() {
        updateLives();
        gameScreen.editRaplaceTag("%lives", livesText);
        gameScreen.editRaplaceTag("%word", word.getHiddenWord());
        gameScreen.editRaplaceTag("%used", usedChars.toString());
    }

    private void updateLives() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < lives; i++) {
            sb.append("O");
        }
        for (int i = 0; i < 10 - lives; i++) {
            if (lives >= 0) {
                sb.append("-");
            }
        }
        sb.append("]");
        livesText = sb.toString();
    }

}
