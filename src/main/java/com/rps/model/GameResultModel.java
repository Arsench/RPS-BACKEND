/**
 *
 */
package com.rps.model;

/**
 * @author arsen
 *
 */
public class GameResultModel {
    private String computerChoice;
    private String result;

    public GameResultModel(String computerChoice, String result) {
        this.computerChoice = computerChoice;
        this.result = result;
    }

    public String getComputerChoice() {
        return computerChoice;
    }

    public void setComputerChoice(String computerChoice) {
        this.computerChoice = computerChoice;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}