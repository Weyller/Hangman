package de.germanspacebuild.games.hangman.screen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Felix on 05.07.2017
 * for Hangman
 *
 * @author Felix
 */
public class MenuScreen extends Screen {

    private Map<Integer, MenuAction> actions = new HashMap<>();

    public MenuScreen(String text) {
        super(text);
        setAwaitsInput(true);
    }

    @Override
    public void print() {
        super.print();
        performAction(Integer.valueOf(input));
    }

    public void performAction(int number) {
        actions.get(number).action();
    }

    public void addMenuAction(int number, MenuAction action) {
        actions.put(number, action);
    }

}
