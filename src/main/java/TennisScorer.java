public class TennisScorer {
    private int ballsWonByPlayer1;
    String[] scores = new String[]{"love-love", "fifteen-love", "thirty-love","","Player 1 wins"};

    public String getMatchScore() {
        return scores[ballsWonByPlayer1];
    }

    public void addPointToPlayer1() {
        ++ballsWonByPlayer1;
    }
}
