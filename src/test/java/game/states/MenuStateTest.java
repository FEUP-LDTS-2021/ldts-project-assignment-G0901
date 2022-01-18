package game.states;

import com.googlecode.lanterna.TerminalSize;
import game.Application;
import game.control.menu.MenuController;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.states.menu.MenuState;
import game.view.menu.MenuView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;


public class MenuStateTest {
    private MenuState state;
    private MenuModel model;
    private GUI gui;
    private Application app;
    private MenuController controller;
    private MenuView view;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        app = Mockito.mock(Application.class);
        controller = Mockito.mock(MenuController.class);
        view = Mockito.mock(MenuView.class);

        model = new MenuModel(new TerminalSize(40,40));
        state = new MenuState(model);

        state.view = view;
        state.controller = controller;

    }

    @Test
    public void step() throws IOException {
        state.step(app, gui);

        Mockito.verify(controller, Mockito.times(1)).step(app, gui.getAction());
        Mockito.verify(view, Mockito.times(1)).draw(gui);
    }
}