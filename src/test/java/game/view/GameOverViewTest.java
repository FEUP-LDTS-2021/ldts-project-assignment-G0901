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
        model = new GameOverModel(new TerminalSize(40, 40));
        graphics = Mockito.mock(TextGraphics.class);
        gui = Mockito.mock(GUI.class);

        gui.graphics = graphics;

        when(gui.getGraphics()).thenReturn(graphics);
        when(gui.getGraphics().getSize()).thenReturn(new TerminalSize(40, 40));

        view = new GameOverView(model);

    }

    @Test
    public void drawElements() throws IOException {
        view.draw(gui);

        verify(graphics, times(size.getColumns() * size.getRows() + 1)).fillRectangle(any(TerminalPosition.class), any(TerminalSize.class), anyChar());
        verify(gui, times(1)).refresh();
    }
}
