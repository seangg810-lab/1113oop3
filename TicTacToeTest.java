
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicTacToeTest {

    @Test
    public void testXWins() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); 
        game.set(1, 0);
        game.set(0, 1); 
        game.set(1, 1); 
        game.set(0, 2); 
        assertTrue(game.isGameOver());
        assertEquals("X 勝利", game.getResult());
    }

    @Test
    public void testOWins() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0); 
        game.set(1, 1); 
        game.set(0, 1); 
        game.set(0, 2); 
        game.set(2, 1);
        game.set(2, 2); 
        assertTrue(game.isGameOver());
        assertEquals("O 勝利", game.getResult());
    }

    @Test
    public void testDraw() {
        TicTacToe game = new TicTacToe();
        game.set(0, 0);
        game.set(0, 1);
        game.set(0, 2);
        game.set(1, 1);
        game.set(1, 0);
        game.set(1, 2);
        game.set(2, 1);
        game.set(2, 0);
        game.set(2, 2);
        assertTrue(game.isGameOver());
        assertEquals("平手", game.getResult());
    }
}
