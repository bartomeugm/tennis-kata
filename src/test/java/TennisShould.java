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
    public void show_forty_when_player_1_scores() {
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer1();

        assertThat(tennisScorer.getMatchScore(), is("forty-love"));
    }

    @Test
    public void show_player_1_wins_when_player_1_wins() {
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer1();

        assertThat(tennisScorer.getMatchScore(), is("Player 1 wins"));
    }

    @Test
    public void show_player_1_has_advantage() {
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2(); //Deuce

        tennisScorer.addPointToPlayer1(); //advantage for player 1

        assertThat(tennisScorer.getMatchScore(), is("advantage for player 1"));
    }
    @Test
    public void show_player_2_has_advantage() {
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2(); //Deuce

        tennisScorer.addPointToPlayer2(); //advantage for player 2

        assertThat(tennisScorer.getMatchScore(), is("advantage for player 2"));
    }

    @Test
    public void show_player_1_has_advantage_when_the_players_get_back_to_the_deuce() {
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2(); // Deuce
        tennisScorer.addPointToPlayer1(); // Adv player 1
        tennisScorer.addPointToPlayer2(); // Deuce

        tennisScorer.addPointToPlayer1(); // advantage for player 1

        assertThat(tennisScorer.getMatchScore(), is("advantage for player 1"));
    }

    @Test
    public void show_player_2_has_advantage_when_the_players_get_back_to_the_deuce() {
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2(); // Deuce
        tennisScorer.addPointToPlayer1(); // Adv player 1
        tennisScorer.addPointToPlayer2(); // Deuce

        tennisScorer.addPointToPlayer2(); // advantage for player 2

        assertThat(tennisScorer.getMatchScore(), is("advantage for player 2"));
    }
    @Test
    public void show_player_2_wins_when_player_2_wins() {
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer2();

        assertThat(tennisScorer.getMatchScore(), is("Player 2 wins"));
    }

    @Test
    public void deuce_when_players_have_both_40_points() {
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer2(); // 40
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer1(); // 40

        assertThat(tennisScorer.getMatchScore(), is("Deuce"));
    } @Test
    public void deuce_when_players_have_reverted_the_advantage() {
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1(); // Deuce

        tennisScorer.addPointToPlayer2(); // Advantage
        tennisScorer.addPointToPlayer1(); // Reverted the advantage. Deuce again

        assertThat(tennisScorer.getMatchScore(), is("Deuce"));
    }



    @Test
    public void player_2_wins_according_to_the_rule_description() {
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2(); // Deuce
        tennisScorer.addPointToPlayer1(); // Adv player 1
        tennisScorer.addPointToPlayer2(); // Deuce

        tennisScorer.addPointToPlayer2(); // advantage
        tennisScorer.addPointToPlayer2(); // player wins

        assertThat(tennisScorer.getMatchScore(), is("Player 2 wins"));
    }
    @Test
    public void player_1_wins_according_to_the_rule_description() {
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2();
        tennisScorer.addPointToPlayer1();
        tennisScorer.addPointToPlayer2(); // Deuce
        tennisScorer.addPointToPlayer1(); // Adv player 1
        tennisScorer.addPointToPlayer2(); // Deuce

        tennisScorer.addPointToPlayer1(); // advantage
        tennisScorer.addPointToPlayer1(); // player wins

        assertThat(tennisScorer.getMatchScore(), is("Player 1 wins"));
    }
}
