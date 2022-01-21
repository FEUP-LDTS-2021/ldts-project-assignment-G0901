package game.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.menu.AboutModel;
import game.view.menu.AboutView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AboutViewTest {
    private AboutView view;
    private AboutModel model;
    private GUI gui;
    private TextGraphics graphics;
    private TerminalSize size;

    @BeforeEach
    void setUp() {
        size = new TerminalSize(40, 40);
        model = new AboutModel();
        graphics = Mockito.mock(TextGraphics.class);
        gui = Mockito.mock(GUI.class);

        when(gui.getGraphics()).thenReturn(graphics);
        when(gui.getGraphics().getSize()).thenReturn(size);

        view = new AboutView(model);
    }

    @Test
    void drawElements() throws IOException {
        view.drawElements(gui);

        verify(gui, Mockito.times(1)).fillScreen(anyString());
        verify(gui, Mockito.times(1)).refresh();
    }

}
