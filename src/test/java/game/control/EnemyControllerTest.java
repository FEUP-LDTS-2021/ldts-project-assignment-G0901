package game.control;

import game.Application;
import game.control.game.EnemyController;
import game.gui.GUI;
import game.model.game.GameModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class EnemyControllerTest {
    private EnemyController enemyController;
    private GameModel game_model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        game_model = mock(GameModel.class);
        enemyController = new EnemyController(game_model);
        app = mock(Application.class);
        gui = mock(GUI.class);
    }

    @Test
    void step() throws IOException {
        enemyController.step(app, gui.getAction());
        verify(game_model,times(2)).getEnemies();
    }

}