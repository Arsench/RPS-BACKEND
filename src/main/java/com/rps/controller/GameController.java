/**
 *
 */
package com.rps.controller;

import com.rps.enums.GameChoice;
import com.rps.model.PlayerChoiceModel;
import com.rps.service.GameServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * @author arsen
 *
 */

@RequestMapping("api/")
@CrossOrigin(origins = {"http://frontrps.duckdns.org:8082"}, methods = {RequestMethod.POST}, allowedHeaders = {"Content-Type"})
@RestController
public class GameController {

    @Autowired
    private GameServiceImpl gameServiceImpl;

    @PostMapping("/play")
    public ResponseEntity<Map<String, String>> playRockPaperScissors(@RequestBody PlayerChoiceModel playerChoice) {
        String gameResult = gameServiceImpl.playRockPaperScissors(playerChoice);
        GameChoice computerChoice = gameServiceImpl.getComputerChoice();
        Map<String, String> response = new HashMap<>();
        response.put("playerChoice", playerChoice.getSelectedElement().toLowerCase());
        response.put("computerChoice", computerChoice.name().toLowerCase());
        response.put("result", gameResult);

        return ResponseEntity.ok(response);
    }
}


