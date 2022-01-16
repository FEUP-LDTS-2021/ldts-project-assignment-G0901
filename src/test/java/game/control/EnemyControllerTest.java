package game.control;

import game.Application;
import game.control.game.EnemyController;
import game.model.game.EnemyModel;
import game.gui.GUI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnemyControllerTest {
    private EnemyController enemyController;
    private EnemyModel model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        model = new EnemyModel();
        enemyController = new EnemyController(model);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void step()  throws IOException {
        enemyController.step(app, gui.getAction());
        assertEquals(21, model.getPosition().getY());
        enemyController.step(app, gui.getAction());
        enemyController.step(app, gui.getAction());
        assertEquals(23, model.getPosition().getY());
    }

}
