import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TennisScorer {
    private Score scorePlayer1 = new Score();
    private Score scorePlayer2 = new Score();
    private List<ScoreRule> rules;

    public TennisScorer(List<ScoreRule> rules) {
        this.rules = rules;
    }

    public String getMatchScore() {
        return rules.stream().map(it -> it.apply(scorePlayer1, scorePlayer2)).filter(Optional::isPresent).findFirst().get().get();
    }

    public void addPointToPlayer1() {
        scorePlayer1.increase();
    }

    public void addPointToPlayer2() {
        scorePlayer2.increase();
    }

    public class Score {
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

        public boolean wins(Score other) {
            return this.ballsWon >= MINIMUM_NUMBER_OF_BALLS_WON_TO_WIN_THE_GAME && this.ballsWon - other.ballsWon >= 2;
        }

        public String formatted() {
            return scores[ballsWon];
        }

        public boolean isSecondAdvantageWith(Score scorePlayer2) {
            return this.ballsWon >= 4 && this.ballsWon - 1 == scorePlayer2.ballsWon;
        }

    }

    public static class ScoreRule {
        public Optional<String> apply(Score scorePlayer1, Score scorePlayer2) {
            return Optional.empty();
        }
    }
}
