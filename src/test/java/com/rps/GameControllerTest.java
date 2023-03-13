package com.rps;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rps.controller.GameController;
import com.rps.model.PlayerChoiceModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPlayRockPaperScissors() throws Exception {
        PlayerChoiceModel playerChoice = new PlayerChoiceModel();
        playerChoice.setSelectedElement("rock");

        mockMvc.perform(post("/api/play")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(playerChoice)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());
    }

     // Helper method to convert objects to JSON strings
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}