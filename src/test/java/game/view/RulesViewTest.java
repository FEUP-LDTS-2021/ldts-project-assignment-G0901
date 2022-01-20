package game.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.menu.RulesModel;
import game.view.menu.RulesView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class RulesViewTest {
    private RulesView view;
    private RulesModel model;
    private GUI gui;
    private TextGraphics graphics;
    private TerminalSize size;

    @BeforeEach
    void setUp() {
        size = new TerminalSize(40, 40);
        model = new RulesModel();
        graphics = Mockito.mock(TextGraphics.class);
        gui = Mockito.mock(GUI.class);

        when(gui.getGraphics()).thenReturn(graphics);
        when(gui.getGraphics().getSize()).thenReturn(new TerminalSize(40, 40));

        view = new RulesView(model);
    }


    @Test
    public void drawElements() throws IOException {
        view.draw(gui);

        Mockito.verify(gui, times(1)).fillScreen(anyString());
        verify(gui, times(1)).refresh();
    }
}
