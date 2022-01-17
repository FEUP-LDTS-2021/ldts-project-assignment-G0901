package game.control;

import com.googlecode.lanterna.TerminalSize;
import game.Application;
import game.control.menu.SelectTrackController;
import game.gui.GUI;
import game.model.Model;
import game.model.game.GameModel;
import game.model.menu.SelectTrackModel;
import game.states.GameState;
import game.states.MenuState;
import game.states.State;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class SelectTrackControllerTest {
    private SelectTrackController controller;
    private SelectTrackModel model;
    private Application app;

    @BeforeEach
    void setUp() {
        app = Mockito.mock(Application.class);
        model = Mockito.mock(SelectTrackModel.class);
        controller = new SelectTrackController(model);
    }

    @Test
    void testNavigation() {
        controller.step(app, GUI.ACTION.RIGHT);
        controller.step(app, GUI.ACTION.LEFT);

        verify(model, times(1)).nextItem();
        verify(model, times(1)).previousItem();
    }

    @Test
    void testSelection() {
        GameState game_state = Mockito.mock(GameState.class);
//TODO
        //controller.step(app, GUI.ACTION.ENTER);

        //verify(app, times(1)).setState(game_state);
    }

    @Test
    void testEscape() {
        MenuState menu_state = Mockito.mock(MenuState.class);
//TODO
        //controller.step(app, GUI.ACTION.ESC);

        //verify(app, times(1)).setState(menu_state);
    }
}
