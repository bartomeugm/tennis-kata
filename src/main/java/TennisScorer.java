import java.util.Arrays;
import java.util.Objects;

public class TennisScorer {
    private Score scorePlayer1 = new Score();
    private Score scorePlayer2 = new Score();

    public String getMatchScore() {
        if (scorePlayer1.isDeucedWith(scorePlayer2)) {
            return "Deuce";
        }
        if (scorePlayer1.hasAdvantageOver(scorePlayer2)) {
            return "advantage for player 1";
        }
        if (scorePlayer2.hasAdvantageOver(scorePlayer1)){
            return "advantage for player 2";
        }
        if (scorePlayer1.wins(scorePlayer2)) {
            return "Player 1 wins";
        }
        if (scorePlayer2.wins(scorePlayer1)) {
            return "Player 2 wins";
        }
        return String.format("%s-%s", scorePlayer1.formatted(), scorePlayer2.formatted());
    }

    public void addPointToPlayer1() {
        scorePlayer1.increase();
    }

    public void addPointToPlayer2() {
        scorePlayer2.increase();
    }

    private class Score {
        public static final int MINIMUM_NUMBER_OF_BALLS_WON_TO_WIN_THE_GAME = 4;
        private String[] scores = new String[]{"love", "fifteen", "thirty", "forty"};

        private int ballsWon = 0;

        public void increase() {
            this.ballsWon++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Score score = (Score) o;
            return ballsWon == score.ballsWon &&
                    Arrays.equals(scores, score.scores);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(ballsWon);
            result = 31 * result + Arrays.hashCode(scores);
            return result;
        }

        public boolean isDeucedWith(Score other) {
            return this.equals(other) && this.ballsWon >= 3;
        }

        public boolean hasAdvantageOver(Score other) {
            return this.ballsWon >= 4 && this.ballsWon - 1 == other.ballsWon;
        }

        private boolean wins(Score other) {
            return this.ballsWon >= MINIMUM_NUMBER_OF_BALLS_WON_TO_WIN_THE_GAME && this.ballsWon - other.ballsWon>= 2;
        }

        public String formatted() {
            return scores[ballsWon];
        }

    }
}
