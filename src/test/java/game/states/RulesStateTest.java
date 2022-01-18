package game.states;

import com.googlecode.lanterna.TerminalSize;
import game.Application;
import game.control.menu.RulesController;
import game.gui.GUI;
import game.model.menu.RulesModel;
import game.states.menu.RulesState;
import game.view.menu.RulesView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class RulesStateTest {
    private RulesState state;
    private RulesModel model;
    private GUI gui;
    private Application app;
    private RulesController controller;
    private RulesView view;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        app = Mockito.mock(Application.class);
        controller = Mockito.mock(RulesController.class);
        view = Mockito.mock(RulesView.class);

        model = new RulesModel(new TerminalSize(40, 40));
        state = new RulesState(model);

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
