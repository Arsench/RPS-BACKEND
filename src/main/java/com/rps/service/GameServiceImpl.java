package com.rps.service;

import com.rps.enums.GameChoice;
import com.rps.exception.InvalidChoiceException;
import com.rps.model.PlayerChoiceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GameServiceImpl implements GameService {
    private static final Logger LOGGER = LoggerFactory.getLogger(GameServiceImpl.class);
    private static final List<GameChoice> CHOICES = Arrays.asList(GameChoice.ROCK, GameChoice.PAPER, GameChoice.SCISSORS);
    private final static String PLAYERS_RESULT = "You win!";
    private final static String COMPUTERS_RESULT = "Computer wins!";
    private final static String TIE_RESULT = "Tie!";
    private GameChoice computerChoice;

    private static final Map<GameChoice, Map<GameChoice, String>> GAME_RESULTS = Map.of(
            GameChoice.ROCK, Map.of(
                    GameChoice.ROCK, TIE_RESULT,
                    GameChoice.PAPER, COMPUTERS_RESULT,
                    GameChoice.SCISSORS, PLAYERS_RESULT
            ),
            GameChoice.PAPER, Map.of(
                    GameChoice.ROCK, PLAYERS_RESULT,
                    GameChoice.PAPER, TIE_RESULT,
                    GameChoice.SCISSORS, COMPUTERS_RESULT
            ),
            GameChoice.SCISSORS, Map.of(
                    GameChoice.ROCK, COMPUTERS_RESULT,
                    GameChoice.PAPER, PLAYERS_RESULT,
                    GameChoice.SCISSORS, TIE_RESULT
            )
    );

    @Override
    public String playRockPaperScissors(PlayerChoiceModel playerChoice) {
        if (playerChoice == null) {
            LOGGER.error("Null or incorrect value was selected by the player!");
            throw new InvalidChoiceException("Null or incorrect value was selected by the player!");
        }
        Random rand = new Random();
        computerChoice = CHOICES.get(rand.nextInt(CHOICES.size()));
        String finalResult = getGameResult(playerChoice, computerChoice);
        LOGGER.info("The element selected by the player is {} and by the computer is {}", playerChoice, computerChoice);
        return finalResult;
    }

    public GameChoice getComputerChoice() {
        return computerChoice;
    }

    private String getGameResult(PlayerChoiceModel playerChoice, GameChoice computerChoice) {
        GameChoice userChoice = GameChoice.valueOf(playerChoice.getSelectedElement().toUpperCase());
        return GAME_RESULTS.get(userChoice).get(computerChoice);
    }

}
