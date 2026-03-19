package com.codedotorg;

import java.util.Random;


public class GameLogic {
    private boolean gameOver = false;
    private String resultMessage = "";
    private static final String[] CHOICES = {"rock", "paper", "scissors"};

    public String getComputerChoice() {
        Random random = new Random();
        int index = random.nextInt(CHOICES.length);
        return CHOICES[index];
    }

    public String determineWinner(String predictedClass, String computerChoice) {
        String output = "You chose " + predictedClass + ", computer chose " + computerChoice + ". ";
        String result;

        if (predictedClass.equals(computerChoice)) {
            result = getTieResult();
        } else if (
            (predictedClass.equals("rock") && computerChoice.equals("scissors")) ||
            (predictedClass.equals("paper") && computerChoice.equals("rock")) ||
            (predictedClass.equals("scissors") && computerChoice.equals("paper"))
        ) {
            result = getUserWinnerResult();
        } else {
            result = getComputerWinnerResult();
        }

        return output + result;
    }

    public String getTieResult() {
        this.gameOver = true;
        this.resultMessage = "It's a tie!";
        return this.resultMessage;
    }

    public String getUserWinnerResult() {
        this.gameOver = true;
        this.resultMessage = "You win!";
        return this.resultMessage;
    }

    public String getComputerWinnerResult() {
        this.gameOver = true;
        this.resultMessage = "Computer wins!";
        return this.resultMessage;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void resetLogic() {
        this.gameOver = false;
        this.resultMessage = "";
    }

    public void resetGame() {
        resetLogic();
    }
}