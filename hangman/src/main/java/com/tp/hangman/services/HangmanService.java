package com.tp.hangman.services;

import com.tp.hangman.models.HangmanGame;
import com.tp.hangman.models.HangmanViewModel;
import com.tp.hangman.persistence.HangmanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//handles the logic for the game
@Component
public class HangmanService {

    @Autowired
    HangmanDao dao;

    public HangmanViewModel getGameById(Integer gameId) {
        HangmanGame game = dao.getGameById( gameId );
        return convertModel( game );
    }


    public HangmanViewModel makeGuess(Integer id, String guess) {
        if (guess.length() != 1) {
            //TODO: make and throw a custom exception
            return null;
        }
        if (id == null) {
            //TODO: make and throw a custom exception
            return null;
        }
        HangmanGame game = dao.getGameById(id);
        if (game == null) {
            return null;
        }
        game.getGuessedLetters().add(guess.charAt(0));
        //
        List<Character> wrongGuesses = game.getGuessedLetters().stream()
                .filter(c -> game.getHiddenWord().indexOf(c) == -1)
                .collect(Collectors.toList());
        if (wrongGuesses.size() > 5) {
            return null;
        }
        HangmanViewModel view = convertModel(game);
        if (view.getPartialWord().replaceAll("\\s+", "")
                .equalsIgnoreCase(game.getHiddenWord())) {
            return null;
        }
        return view;
    }


    private HangmanViewModel convertModel(HangmanGame game) {
        //TODO: generate string with hidden characters for unguessed letters
        //and build view model object (using the setters)
        String partialWord = "";
        // LOGIC
        String hiddenWord = game.getHiddenWord();
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (game.getGuessedLetters().contains(hiddenWord.charAt(i))) {
                partialWord += hiddenWord.charAt(i) + " ";
            } else {
                partialWord += "* ";
            }
        }
        HangmanViewModel toReturn = new HangmanViewModel();
        toReturn.setPartialWord(partialWord);
        toReturn.setGuessedLetters(game.getGuessedLetters());
        return toReturn;

    }
}
