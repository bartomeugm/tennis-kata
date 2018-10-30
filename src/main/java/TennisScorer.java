public class TennisScorer {
    private int ballsWonByPlayer1;
    private int ballsWonByPlayer2;
    private String[] player1Scores = new String[]{"love", "fifteen", "thirty","","Player 1 wins"};
    private String[] player2Scores = new String[]{"love", "fifteen", "thirty","","Player 2 wins"};

    public String getMatchScore() {
        if(ballsWonByPlayer2 == ballsWonByPlayer1 && ballsWonByPlayer2 == 3){
            return "Deuce";
        }
        if(ballsWonByPlayer2 == 4){
            return player2Scores[ballsWonByPlayer2];
        } else if (ballsWonByPlayer1 == 4 ){
            return player1Scores[ballsWonByPlayer1];
        }
        return String.format("%s-%s", player1Scores[ballsWonByPlayer1], player2Scores[ballsWonByPlayer2]);
    }

    public void addPointToPlayer1() {
        ++ballsWonByPlayer1;
    }

    public void addPointToPlayer2() {
        ++ballsWonByPlayer2;
    }
}
