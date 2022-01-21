package game.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.menu.SelectTrackModel;
import game.view.menu.SelectTrackView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SelectTrackViewTest {
    private SelectTrackView view;
    private SelectTrackModel model;
    private GUI gui;

    @BeforeEach
    void setUp() {
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(graphics.getSize()).thenReturn(new TerminalSize(100, 100));
        gui = Mockito.mock(GUI.class);
        Mockito.when(gui.getGraphics()).thenReturn(graphics);

        model = new SelectTrackModel();
        view = new SelectTrackView(model);
    }

    @Test
    void draw() throws IOException {
        view.drawElements(gui);

        Mockito.verify(gui, times(1)).fillScreen(anyString());
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
