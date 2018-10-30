public class TennisScorer {
    private int ballsWonByPlayer1;
    private int ballsWonByPlayer2;
    private String[] player1Scores = new String[]{"love-love", "fifteen-love", "thirty-love","","Player 1 wins"};
    private String[] player2Scores = new String[]{"love-love", "fifteen-love", "thirty-love","","Player 2 wins"};

    public String getMatchScore() {
        if(ballsWonByPlayer2 == ballsWonByPlayer1 && ballsWonByPlayer2 == 3){
            return "Deuce";
        }
        if(ballsWonByPlayer1 != 0) {
            return player1Scores[ballsWonByPlayer1];
        } else {
            return player2Scores[ballsWonByPlayer2];
        }
    }

    public void addPointToPlayer1() {
        ++ballsWonByPlayer1;
    }

    public void addPointToPlayer2() {
        ++ballsWonByPlayer2;
    }
}
