package game.view;

import com.googlecode.lanterna.TerminalSize;
import game.gui.GUI;
import game.model.menu.SelectTrackModel;
import game.view.menu.SelectTrackView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class SelectTrackViewTest {
    private SelectTrackView view;
    private SelectTrackModel model;
    private GUI gui;

    @BeforeEach
    void setUp() {
        model = new SelectTrackModel();
        view = new SelectTrackView(model);

        //gui = Mockito.mock(GUI.class);
        gui = new GUI(new TerminalSize(1, 1));
    }

    @Test
    void draw() throws IOException {
        view.drawElements(gui);
    }
}
