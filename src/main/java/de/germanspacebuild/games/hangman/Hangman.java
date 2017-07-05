package de.germanspacebuild.games.hangman;

/**
 * Created by Felix on 12.06.2017
 * for Hangman
 *
 * @author Felix
 */
public class Hangman {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(new Word("test"));
        game.init();
    }

}
