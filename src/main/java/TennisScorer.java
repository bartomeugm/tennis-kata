public class TennisScorer {
    private int ballsWonByPlayer1;
    private int ballsWonByPlayer2;
    private String[] scores = new String[]{"love", "fifteen", "thirty", "forty"};

    public String getMatchScore() {
        if (ballsWonByPlayer2 == ballsWonByPlayer1 && ballsWonByPlayer2 >= 3) {
            return "Deuce";
        }
        if (ballsWonByPlayer1 >= 4 && ballsWonByPlayer1 - 1 == ballsWonByPlayer2) {
            return "advantage for player 1";
        }
        if (ballsWonByPlayer2 >= 4 && ballsWonByPlayer2 - 1 == ballsWonByPlayer1) {
            return "advantage for player 2";
        }
        if (ballsWonByPlayer2 >= 4 && ballsWonByPlayer2 - ballsWonByPlayer1 >= 2) {
            return "Player 2 wins";
        } else if (ballsWonByPlayer1 >= 4 && ballsWonByPlayer1 - ballsWonByPlayer2 >= 2) {
            return "Player 1 wins";
        }
        return String.format("%s-%s", scores[ballsWonByPlayer1], scores[ballsWonByPlayer2]);
    }

    public void addPointToPlayer1() {
        ++ballsWonByPlayer1;
    }

    public void addPointToPlayer2() {
        ++ballsWonByPlayer2;
    }
}
