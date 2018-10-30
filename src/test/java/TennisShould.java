import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TennisShould {

    private TennisScorer tennisScorer;

    @Before
    public void setUp() throws Exception {
        tennisScorer = new TennisScorer();
    }

    @Test
    public void start_scorers_at_0(){

        assertThat(tennisScorer.getMatchScore(), is("love-love"));
    }

    @Test
    public void show_fifteen_when_player_1_scores() {
        tennisScorer.addPointToPlayer1();

        assertThat(tennisScorer.getMatchScore(), is("fifteen-love"));
    }

    @Test
    public void show_thirty_when_player_1_scores() {
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer1();

        assertThat(tennisScorer.getMatchScore(), is("thirty-love"));
    }

    @Test
    public void show_player_1_wins_when_player_1_wins() {
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer1();

        assertThat(tennisScorer.getMatchScore(), is("Player 1 wins"));
    }
}
