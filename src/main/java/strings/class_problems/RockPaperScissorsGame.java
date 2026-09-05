package strings.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    public String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        RockPaperScissorsGame game = new RockPaperScissorsGame();

        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int wins = 0, losses = 0, draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < playerMoves.length; i++) {
            String playerMove = playerMoves[i];
            String computerMove = moves[random.nextInt(3)];
            String result = game.playRound(playerMove, computerMove);

            System.out.println((i + 1) + " | " + playerMove + " | " + computerMove + " | " + result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPercentage = (wins / (double) playerMoves.length) * 100;
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
    }
}