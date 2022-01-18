package game.control;

import com.googlecode.lanterna.TerminalSize;
import game.Application;
import game.control.menu.GameOverController;
import game.gui.GUI;
import game.model.menu.GameOverModel;
import game.states.game.GameState;
import game.states.menu.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

public class GameOverControllerTest {
    private GameOverController controller;
    private GameOverModel model;
    private Application app;
    private GUI gui;
    private GameState game_state;

    @BeforeEach
    void setUp() {
        model = Mockito.mock(GameOverModel.class);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
        game_state = Mockito.mock(GameState.class);

        controller = new GameOverController(model);
    }

    @Test
    void step() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.UP);
        controller.step(app, gui.getAction());
        Mockito.verify(model, Mockito.times(1)).previousItem();


        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.DOWN);
        controller.step(app, gui.getAction());
        Mockito.verify(model, Mockito.times(1)).nextItem();


        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ESC);
        controller.step(app, gui.getAction());
        Mockito.verify(app, Mockito.times(1)).setState(null);

        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ENTER);
        Mockito.when(model.whichSelected()).thenReturn(0);
        Mockito.when(model.getSize()).thenReturn(new TerminalSize(40, 40));
        controller.step(app, gui.getAction());
        Mockito.verify(app, Mockito.times(1)).setState(any(GameState.class));

        Mockito.when(model.whichSelected()).thenReturn(1);
        controller.step(app, gui.getAction());
        Mockito.verify(app, Mockito.times(1)).setState(any(MenuState.class));

    }

}
