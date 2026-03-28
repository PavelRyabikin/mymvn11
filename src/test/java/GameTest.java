import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    public void shouldPlayer1Win() {
        Game game = new Game();

        Player p1 = new Player(1, "Иван", 100);
        Player p2 = new Player(2, "Олег", 50);

        game.register(p1);
        game.register(p2);

        int result = game.round("Иван", "Олег");

        assertEquals(1, result);
    }

    @Test
    public void shouldPlayer2Win() {
        Game game = new Game();

        Player p1 = new Player(1, "Иван", 50);
        Player p2 = new Player(2, "Олег", 100);

        game.register(p1);
        game.register(p2);

        int result = game.round("Иван", "Олег");

        assertEquals(2, result);
    }

    @Test
    public void shouldBeDraw() {
        Game game = new Game();

        Player p1 = new Player(1, "Иван", 100);
        Player p2 = new Player(2, "Олег", 100);

        game.register(p1);
        game.register(p2);

        int result = game.round("Иван", "Олег");

        assertEquals(0, result);
    }

    @Test
    public void shouldThrowIfFirstNotRegistered() {
        Game game = new Game();

        Player p2 = new Player(2, "Олег", 100);
        game.register(p2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Иван", "Олег");
        });
    }

    @Test
    public void shouldThrowIfSecondNotRegistered() {
        Game game = new Game();

        Player p1 = new Player(1, "Иван", 100);
        game.register(p1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Иван", "Олег");
        });
    }

    @Test
    void shouldCoverPlayerClass() {
        Player player = new Player(1, "Иван", 10);

        assertEquals(1, player.getId());
        assertEquals("Иван", player.getName());
        assertEquals(10, player.getStrength());
    }
}