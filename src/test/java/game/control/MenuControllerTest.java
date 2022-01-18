/*package game.control;

import com.googlecode.lanterna.TerminalSize;
import game.Application;
import game.control.menu.MenuController;
import game.gui.GUI;
import game.model.GameModelTest;
import game.model.game.GameModel;
import game.model.menu.MenuModel;
import game.states.game.GameState;
import game.states.menu.MenuState;
import game.states.menu.RulesState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

public class MenuControllerTest {
    private MenuController controller;
    private MenuModel model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        model = Mockito.mock(MenuModel.class);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);

        controller = new MenuController(model);

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
        Mockito.verify(app, Mockito.times(1)).setState(any(RulesState.class));

        Mockito.when(model.whichSelected()).thenReturn(3);
        Mockito.verify(app, Mockito.times(1)).setState(null);

    }
}*/
