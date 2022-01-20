package game.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.menu.GameOverModel;
import game.view.menu.GameOverView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.*;

public class GameOverViewTest {
    private GameOverView view;
    private GameOverModel model;
    private GUI gui;
    private TextGraphics graphics;
    private TerminalSize size;

    @BeforeEach
    void setUp() {
        size = new TerminalSize(40, 40);
        graphics = Mockito.mock(TextGraphics.class);
        gui = Mockito.mock(GUI.class);
        when(gui.getGraphics()).thenReturn(graphics);
        when(gui.getGraphics().getSize()).thenReturn(size);

        model = new GameOverModel("Monza");

        view = new GameOverView(model);

    }

    @Test
    public void drawElements() throws IOException {
        view.draw(gui);

        verify(gui, times(1)).fillScreen(anyString());
        verify(gui, times(1)).refresh();
    }

    @Test
    public void testRow() {
        int row = view.calculateRow(size, 1);

        assertEquals(34, row);
    }
}
