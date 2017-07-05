package de.germanspacebuild.games.hangman.screen;

/**
 * Created by Felix on 05.07.2017
 * for Hangman
 *
 * @author Felix
 */
@FunctionalInterface
public interface MenuAction {

    /**
     * Contains the code that will be run when the action was selected by the user.
     */
    void action();

}
