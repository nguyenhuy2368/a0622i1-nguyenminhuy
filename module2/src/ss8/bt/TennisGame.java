package ss8.bt;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = "";
        boolean isEnd = player1Score >= 4 || player2Score >= 4;
        boolean isDraw = player1Score == player2Score;


        if (isDraw) {
            return getDraw(player1Score);
        } else if (isEnd) {
            return getEndGame(player1Score, player2Score);
        } else {
            score = getPlayerScore(player1Score) + " - " + getPlayerScore(player2Score);
        }
        return score;
    }

    private static String getEndGame(int player1Score, int player2Score) {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private static String getDraw(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";


        }
    }

    private static String getPlayerScore(int playerScore) {
        switch (playerScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }
}
